package io.renren.modules.job.task;

import io.renren.common.request.analysis.HtmlUtil;
import io.renren.common.request.constant.HeaderConstant;
import io.renren.common.request.httpclient.HttpClientUtil;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		long start = detailService.queryMaxId();
		
		try {
			String json = HttpClientUtil.get(Url.getDeatil(),Header.header);
			long end = EntityCompile.getUrl(json);
			for (long i = start; i < end; i++) {
				try {
				System.out.println("当前是"+i+"条，");
				if(i%30000==0){
					detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
				}
				String html = HttpClientUtil.get(Url.getDetail(i),Header.header);
				TbDetailsEntity comileDetail = EntityCompile.comileDetail(html,i);
				detailService.save(comileDetail);
				System.out.println("保存成功");
				} catch (Exception e) {
					System.out.println("保存失败");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
