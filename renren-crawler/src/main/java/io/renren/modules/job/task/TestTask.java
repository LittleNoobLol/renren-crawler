package io.renren.modules.job.task;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.common.DetailMagic;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
import us.codecraft.webmagic.Spider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
		// 创建magic爬虫
		Spider create = Spider.create(new DetailMagic(detailService));
		// 添加url
		for (int i = 34018832; i < 34018851; i++) {
			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);
		} 
		// 设置线程数并启动
		create.thread(5).run();
	}
	
	
	/*
	 * public void test2() { logger.info("我是不带参数的test2方法，正在被执行"); }
	 */

	/*
	 * @Override public void run() { ForeigninfoService foreigninfoService =
	 * (ForeigninfoService) SpringContextUtils.getBean("foreigninfoService");
	 * ForeigninfoEntity info = foreigninfoService.queryNoyetInfo(); try {
	 * String html = HttpClientUtil.get(info.getUrls(),
	 * HeaderConstant.getHeaderPage()); HtmlUtil.infoAnalysis(info.getUrls(),
	 * html, info); info.setIsquerys(1); } catch (Exception e) {
	 * logger.error("执行http请求失败 "); info.setIsquerys(-1); } finally {
	 * foreigninfoService.update(info); countDownLatch.countDown(); } }
	 */

}
