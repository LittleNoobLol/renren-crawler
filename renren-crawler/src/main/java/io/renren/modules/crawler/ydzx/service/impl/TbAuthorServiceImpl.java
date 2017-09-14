package io.renren.modules.crawler.ydzx.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;

@Service("tbAuthorService")
public class TbAuthorServiceImpl implements TbAuthorService {
	@Autowired
	private TbAuthorDao tbAuthorDao;
	@Autowired
	private TbDetailsService tbDetailsService;

	private Logger logger = LoggerFactory.getLogger(TbAuthorServiceImpl.class);

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
				// 判断数据库中是否已经有改作者
				if (tbAuthorDao.queryObject(id) == null) {
					tbAuthorDao.save(comileAuthor);
				}
				
				// 获取作者的文章
				List<TbDetailsEntity> comileDetails = EntityCompile.comileDetails(json);
				// 记录作者的文章总数
				int count = 0;
				/*//保存记录数据
				if (comileDetails != null && comileDetails.size() > 0) {
					for (TbDetailsEntity tbDetailsEntity : comileDetails) {
						try {
							tbDetailsService.save(tbDetailsEntity);
							count++;
						} catch (Exception e) {
						}
					}
				}*/
				// 开始递归获取作者更多的文章
				count = chirden(comileDetails, id, 0, count);
				map.put("name", comileAuthor.getChannelName());
				map.put("count", count + "");

			}
		} catch (Exception e) {
			return R.error("由于网络或网站原因获取作者信息失败");
		}
		return R.ok().put("data", map);
	}

	/**
	 * 获取作者更多文章递归方法
	 * @param 上一页的list数据
	 * @param 作者id
	 * @param 页数
	 * @param 成功条数
	 * @return 成功条数
	 */
	public int chirden(List<TbDetailsEntity> comileDetails, int id, int page, int count) {
		if (comileDetails != null && comileDetails.size() > 0) {
			// 代表还有下一页
			if (comileDetails.size() == 10) {
				page += 10;
				try {
					// 获取这一页的json数据
					String json = HttpClientUtil.get(Url.getAuthor(id, page), Header.header);
					// 转解析成为实体类
					List<TbDetailsEntity> comile = EntityCompile.comileDetails(json);
					// 遍历
					for (TbDetailsEntity tbDetailsEntity : comile) {
						try {
							// 获取html
							String html = HttpClientUtil.get(tbDetailsEntity.getUrl(), Header.header);
							
							Document doc = Jsoup.parse(html);
							// 获取正文内容
							String contenthtml = doc.select(".content-bd").html();
							tbDetailsEntity.setContextHtml(contenthtml);
							// 注释下载图片,测试暂时不需要
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
							logger.error("遍历递归作者数据异常",e);
						}finally {
							try {
								tbDetailsService.save(tbDetailsEntity);
								count++;
							} catch (Exception e) {
								logger.error("递归作者保存数据异常",e);
							}
						}
					}
					count = chirden(comile, id, page, count);
				} catch (Exception e) {
					logger.error("解析递归数据时异常",e);
				}
			}
		}
		return count;
	}
}
