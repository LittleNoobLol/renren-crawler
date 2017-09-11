package io.renren.modules.crawler.ydzx.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.DateUtils;
import io.renren.modules.crawler.ydzx.common.entity.NewsJson;
import io.renren.modules.crawler.ydzx.common.entity.Result;
import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

public class EntityCompile {

	/***
	 * 
	 * @Description 对于新闻列表json数据解析
	 * @author lixin
	 * @date 2017年9月8日
	 */
	public static long getUrl(String json) {
		// 获取新闻列表集合
		NewsJson news = JSON.parseObject(json, NewsJson.class);
		// 获取第一个元素
		Result result = news.getResult().get(0);
		// 获取url
		String url = result.getUrl();
		// 截取获取最新的id
		String substring = url.substring(url.lastIndexOf('=') + 1, url.length());
		return Long.valueOf(substring);
	}

	/***
	 * 
	 * @Description 获取文章里面的图片
	 * @author lixin
	 * @date 2017年9月10日
	 * @param doc
	 * @return
	 */
	public static List<String> getImages(Document doc) {
		List<String> images = null;
		Elements select = doc.select(".content-bd");
		if (select != null && !select.text().equals("")) {
			images = new ArrayList<String>();
			Elements imgs = select.select("img");
			for (Element element : imgs) {
				String src = element.attr("src");
				images.add(src);
			}
		}
		return images;
	}

	/***
	 * 
	 * @Description 详情页面获取信息
	 * @author lixin
	 * @date 2017年9月5日
	 * @param html
	 * @return
	 */
	public static TbDetailsEntity comileDetail(String html, int id) {
		TbDetailsEntity entity = new TbDetailsEntity();
		entity.setId(id);
		Document doc = Jsoup.parse(html);

		// 文章正文内容
		Elements context = doc.select(".content-bd");
		entity.setContextHtml(context.html());

		// 获取文章作者
		String author = doc.select(".meta a").attr("href");
		author = author.substring(author.indexOf("m") + 1, author.length());
		entity.setAuthorId(Integer.valueOf(author));

		// 获取日期
		String date = doc.select(".meta span:eq(0)").text();
		entity.setDate(DateUtils.parse(date, "yyyy.MM.dd"));

		// 标题
		String title = doc.select(".left-wrapper h3").text();
		entity.setTitle(title);

		return entity;
	}

	public static TbDetailsEntity comileDetail(Document doc, String url) {
		url = url.substring(url.lastIndexOf('=') + 1, url.length());

		TbDetailsEntity entity = new TbDetailsEntity();
		entity.setId(Integer.valueOf(url));

		// 标题
		String title = doc.select(".left-wrapper h2").text();
		entity.setTitle(title);

		// 文章简介
		String summary = doc.select("head meta[name=description]").attr("content");
		entity.setSummary(summary);

		// 文章正文内容
		Elements context = doc.select(".content-bd");
		entity.setContextHtml(context.html());

		// 获取文章作者
		String author = doc.select(".right-wrapper .wemedia-wrapper a:eq(0)").attr("href");
		author = author.substring(author.indexOf("m") + 1, author.length());
		entity.setAuthorId(Integer.valueOf(author));

		Elements select = doc.select(".left-wrapper .meta span");// 获取日期
		String date;
		if (select.size() == 5) {
			// 获取日期
			date = doc.select(".left-wrapper .meta span:eq(1)").text();
		} else {
			date = doc.select(".left-wrapper .meta span:eq(2)").text();
		}

		if (date.indexOf("小时前") == 1) {
			// 截取 小时前
			String substring = date.substring(0, date.indexOf("小时前"));
			// 转换
			int hour = Integer.valueOf(substring);
			// 获取他的相反数
			Date hoursAgoTime = DateUtils.getHoursAgoTime(0 - hour);
			// 保存
			entity.setDate(hoursAgoTime);
		} else if (date.indexOf("天前") == 1) {
			// 截取 小时前
			String substring = date.substring(0, date.indexOf("天前"));
			// 转换
			int day = Integer.valueOf(substring);
			// 获取他的相反数
			Date dayAgoTime = DateUtils.getdayAgoTime(0 - day);
			// 保存
			entity.setDate(dayAgoTime);
		} else if (date.indexOf("昨天") == 1) {
			Date dayAgoTime = DateUtils.getdayAgoTime(-1);
			entity.setDate(dayAgoTime);
		} else if (date.indexOf("前天") == 1) {
			Date dayAgoTime = DateUtils.getdayAgoTime(-2);
			entity.setDate(dayAgoTime);
		} else {
			entity.setDate(DateUtils.parse(date, "yyyy.MM.dd"));
		}
		return entity;
	}

	public static TbAuthorEntity comileAuthor(String json) {
		// 转化对象
		NewsJson author = JSON.parseObject(json, NewsJson.class);
		// 表示没有此用户
		if (author.getReason() != null) {
			return null;
		}

		TbAuthorEntity tbAuthor = new TbAuthorEntity();

		// 获取id
		String channel_id = author.getChannel_id();
		// 移除 id前面的m
		channel_id = channel_id.substring(1, channel_id.length());
		// 设置id
		tbAuthor.setId(Integer.valueOf(channel_id));
		// 订阅人数
		String bookcount = author.getBookcount();
		// 声明转换后的订阅人数
		int bookCount = 0;
		// 订阅人数没有超过1万
		if (bookcount.indexOf('万') == -1) {
			// 去除最后 人订阅 三个字
			bookcount = bookcount.substring(0, bookcount.length() - 3);
			bookCount = Integer.valueOf(bookcount);
		} else {
			// 去除最后 万人订阅 四个字
			bookcount = bookcount.substring(0, bookcount.length() - 4);
			Double valueOf = Double.valueOf(bookcount);
			// 强转int
			bookCount = (int) (valueOf * 10000);
		}

		// 设置订阅人数
		tbAuthor.setBookCount(bookCount);
		tbAuthor.setChannelImage(author.getChannel_image());
		tbAuthor.setChannelName(author.getChannel_media().getMedia_name());
		tbAuthor.setChannelSummary(author.getChannel_summary());
		tbAuthor.setChannelType(author.getChannel_type());
		tbAuthor.setMediaDomain(author.getChannel_media().getMedia_domain());

		return tbAuthor;
	}

	/***
	 * 
	 * @Description 合并作者里面的文章
	 * @author lixin
	 * @date 2017年9月5日
	 * @param json
	 * @return
	 */
	public static List<TbDetailsEntity> comileDetails(String json) {
		// 转化对象
		NewsJson author = JSON.parseObject(json, NewsJson.class);
		// 获取id
		String channel_id = author.getChannel_id();
		// 移除 id前面的m
		channel_id = channel_id.substring(1, channel_id.length());

		List<Result> result = author.getResult();
		List<TbDetailsEntity> details = null;
		if (result != null && result.size() > 0) {
			details = new ArrayList<TbDetailsEntity>();
			for (Result r : result) {
				TbDetailsEntity entity = new TbDetailsEntity();
				String url = r.getUrl();
				url = url.substring(url.lastIndexOf("=") + 1, url.length());
				entity.setId(Integer.valueOf(url));
				entity.setAuthorId(Integer.valueOf(channel_id));
				// entity.setContextHtml(contextHtml);
				// entity.setContextText(contextText);
				entity.setCtype(r.getCtype());
				entity.setDate(DateUtils.parse(r.getDate()));
				entity.setDocid(r.getDocid());
				entity.setImages(r.getImage());
				entity.setSummary(r.getSummary());
				entity.setTitle(r.getTitle());
				entity.setUrl(r.getUrl());
				details.add(entity);
			}
		}
		return details;
	}

}
