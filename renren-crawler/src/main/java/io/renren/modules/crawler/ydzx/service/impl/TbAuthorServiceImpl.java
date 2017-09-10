package io.renren.modules.crawler.ydzx.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.R;
import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.dao.TbAuthorDao;
import io.renren.modules.crawler.ydzx.dao.TbDetailsDao;
import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbAuthorService;
import io.renren.modules.crawler.ydzx.url.Url;

@Service("tbAuthorService")
public class TbAuthorServiceImpl implements TbAuthorService {
	@Autowired
	private TbAuthorDao tbAuthorDao;
	@Autowired
	private TbDetailsDao tbDetailsDao;

	@Override
	public TbAuthorEntity queryObject(Integer id) {
		return tbAuthorDao.queryObject(id);
	}

	@Override
	public List<TbAuthorEntity> queryList(Map<String, Object> map) {
		return tbAuthorDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return tbAuthorDao.queryTotal(map);
	}

	@Override
	public void save(TbAuthorEntity tbAuthor) {
		tbAuthorDao.save(tbAuthor);
	}

	@Override
	public void update(TbAuthorEntity tbAuthor) {
		tbAuthorDao.update(tbAuthor);
	}

	@Override
	public void delete(Integer id) {
		tbAuthorDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		tbAuthorDao.deleteBatch(ids);
	}

	@Override
	public R crawlerAuthor(String authorUrl) {
		int id = Integer.valueOf(authorUrl.substring(authorUrl.lastIndexOf("m") + 1, authorUrl.length()));
		Map<String, String> map = new HashMap<String, String>();
		try {
			String json = HttpClientUtil.get(Url.getAuthor(id, 0), Header.header);
			TbAuthorEntity comileAuthor = EntityCompile.comileAuthor(json);
			if (comileAuthor == null) {
				map.put("name", "没有此作者");
				map.put("count", "0");
			} else {

				if (tbAuthorDao.queryObject(id) == null) {
					tbAuthorDao.save(comileAuthor);
				}

				List<TbDetailsEntity> comileDetails = EntityCompile.comileDetails(json);
				int count = 0;
				if (comileDetails != null && comileDetails.size() > 0) {
					for (TbDetailsEntity tbDetailsEntity : comileDetails) {
						try {
							tbDetailsDao.save(tbDetailsEntity);
							count++;
						} catch (Exception e) {
						}
					}
				}
				count = chirden(comileDetails, id, 0, count);
				map.put("name", comileAuthor.getChannelName());
				map.put("count", count + "");

			}
		} catch (Exception e) {
			return R.error("由于网络或网站原因获取作者信息失败");
		}
		return R.ok().put("data", map);
	}

	public int chirden(List<TbDetailsEntity> comileDetails, int id, int page, int count) {
		if (comileDetails != null && comileDetails.size() > 0) {
			// 代表还有下一页
			if (comileDetails.size() == 10) {
				page += 10;
				try {
					String json = HttpClientUtil.get(Url.getAuthor(id, page), Header.header);
					List<TbDetailsEntity> comile = EntityCompile.comileDetails(json);
					for (TbDetailsEntity tbDetailsEntity : comile) {
						try {
							String html = HttpClientUtil.get(tbDetailsEntity.getUrl(), Header.header);
							Document doc = Jsoup.parse(html);
							String contenthtml = doc.select(".content-bd").html();
							String contenttext = doc.select(".content-bd").text();
							tbDetailsEntity.setContextHtml(contenthtml);
							tbDetailsEntity.setContextText(contenttext);
							List<String> images = EntityCompile.getImages(doc);
							if (images != null && images.size() > 0) {
								for (String url : images) {
									try {
										String fileName = url.substring(url.lastIndexOf("=") + 1, url.length());
										HttpClientUtil.download(url, Header.header, "home/ydzx/images", fileName+".png");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						} catch (Exception e) {
						}
						try {
							tbDetailsDao.save(tbDetailsEntity);
							count++;
						} catch (Exception e) {
						}
					}
					count = chirden(comile, id, page, count);
				} catch (Exception e) {
				}
			}
		}
		return count;
	}
}
