package io.renren.modules.crawler.ydzx.common;

import java.util.List;

import com.alibaba.fastjson.JSON;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.ydzx.common.entity.NewsJson;
import io.renren.modules.crawler.ydzx.common.entity.Result;
import io.renren.modules.crawler.ydzx.url.Url;

public class YdzxCommon {

	/***
	 * 
	 * @Description 获取最新的新闻id
	 * @author lixin
	 * @date 2017年9月9日
	 * @param count
	 * @return id
	 */
	public static int getNewsId(int count) {
		if (count <= 3) {
			try {
				String json = HttpClientUtil.get(Url.getDeatil(), Header.header);
				NewsJson news = JSON.parseObject(json, NewsJson.class);
				List<Result> results = news.getResult();
				Result result = results.get(results.size() - 2);
				String url = result.getUrl();
				url = url.substring(url.lastIndexOf('=') + 1, url.length());
				return Integer.valueOf(url);
			} catch (Exception e) {
				count++;
				return getNewsId(count);
			}
		} else {
			return 0;
		}
	}
}
