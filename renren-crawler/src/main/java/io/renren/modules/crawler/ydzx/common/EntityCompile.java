package io.renren.modules.crawler.ydzx.common;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.DateUtils;
import io.renren.modules.crawler.ydzx.common.entity.Author;
import io.renren.modules.crawler.ydzx.common.entity.Result;
import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

public class EntityCompile {

	public static TbAuthorEntity comileAuthor(String json) {
		// 转化对象
		Author author = JSON.parseObject(json, Author.class);
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
	
	public static List<TbDetailsEntity> comileDetails(String json){
		// 转化对象
		Author author = JSON.parseObject(json, Author.class);
		// 获取id
		String channel_id = author.getChannel_id();
		// 移除 id前面的m
		channel_id = channel_id.substring(1, channel_id.length());
		
		List<Result> result = author.getResult();
		List<TbDetailsEntity> details=null;
		if (result != null && result.size() > 0) {
			details=new ArrayList<TbDetailsEntity>();
			for (Result r : result) {
				TbDetailsEntity entity=new TbDetailsEntity();
				String url = r.getUrl();
				url = url.substring(url.lastIndexOf("=")+1,url.length());
				entity.setId(Long.valueOf(url));
				entity.setAuthorId(Integer.valueOf(channel_id));
				//entity.setContextHtml(contextHtml);
				//entity.setContextText(contextText);
				entity.setCtype(r.getCtype());
				entity.setDate(DateUtils.parse(r.getDate()));
				entity.setDocid(r.getDocid());
				entity.setDtype(r.getDtype());
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
