package io.renren.modules.job.task;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.common.YdzxCommon;
import io.renren.modules.crawler.ydzx.common.DetailMagic;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.common.entity.NewsJson;
import io.renren.modules.crawler.ydzx.common.entity.Result;
import io.renren.modules.crawler.ydzx.entity.TbAuthorEntity;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
import us.codecraft.webmagic.Spider;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 
 * testTask为spring bean的名称
 * 
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void test(String params) {
		// 获取链接对象
		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		int start = detailService.queryMaxId() + 1;
		int end = start + 30;
		// 创建magic爬虫
		Spider create = Spider.create(new DetailMagic(detailService));
		// 添加url
		for (int i = start; i <= end; i++) {
			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);
		}
		// 设置线程数并启动
		create.thread(30).run();
	}

}
