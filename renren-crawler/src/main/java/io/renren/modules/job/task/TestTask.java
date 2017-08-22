package io.renren.modules.job.task;

import io.renren.common.request.analysis.HtmlUtil;
import io.renren.common.request.constant.HeaderConstant;
import io.renren.common.request.httpclient.HttpClientUtil;
import io.renren.modules.crawler.entity.ForeigninfoEntity;
import io.renren.modules.crawler.service.ForeigninfoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * testTask为spring bean的名称
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("testTask")
public class TestTask{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ForeigninfoService foreigninfoService;

	public void test(String params) {
		logger.info("我是爬虫请求，正在被执行，参数为：" + params);
		
		
	}
/*
	public void test2() {
		logger.info("我是不带参数的test2方法，正在被执行");
	}*/

	/*@Override
	public void run() {
		ForeigninfoService foreigninfoService = (ForeigninfoService) SpringContextUtils.getBean("foreigninfoService");
		ForeigninfoEntity info = foreigninfoService.queryNoyetInfo();
		try {
			String html = HttpClientUtil.get(info.getUrls(), HeaderConstant.getHeaderPage());
			HtmlUtil.infoAnalysis(info.getUrls(), html, info);
			info.setIsquerys(1);
		} catch (Exception e) {
			logger.error("执行http请求失败 ");
			info.setIsquerys(-1);
		} finally {
			foreigninfoService.update(info);
			countDownLatch.countDown();
		}
	}*/
}
