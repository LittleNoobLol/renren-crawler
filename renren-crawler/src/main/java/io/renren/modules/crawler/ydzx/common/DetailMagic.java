package io.renren.modules.crawler.ydzx.common;

import org.jsoup.nodes.Document;

import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class DetailMagic implements PageProcessor {

	public DetailMagic() {
	}

	public DetailMagic(TbDetailsService detailService) {
		this.detailService = detailService;
	}

	private TbDetailsService detailService;
	private Site site = Site.me()
			.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
			.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			.addHeader("Accept-Encoding", "gzip, deflate, br")
			.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3").addHeader("Cache-Control", "max-age=0")
			.addHeader("Connection", "keep-alive").addHeader("Upgrade-Insecure-Requests", "1").setRetryTimes(3)
			.setSleepTime(500).setTimeOut(10000);

	@Override
	public void process(Page page) {
		// 获取document对象
		Document doc = page.getHtml().getDocument();
		// 如果跳回首页 ，则表示没有这篇新闻
		if (doc.select("body").attr("class").equals("page-index")
				|| doc.select("head title").text().equals("【一点资讯】为你私人定制的资讯客户端 - Yidianzixun.com")) {
			page.setSkip(true);
			return;
		} 

		TbDetailsEntity comileDetail = EntityCompile.comileDetail(doc, page.getUrl().toString());

//		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		//if(detailService!=null){
		detailService.save(comileDetail);
		//}

	}

	@Override
	public Site getSite() {
		return site;
	}

	/*public static void main(String[] args) {

		//Spider create = Spider.create(new DetailMagic());
//		for (int i = 34018832; i < 34018851; i++) {
//			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);
//		}
		//create.thread(5).run();

		Spider.create(new DetailMagic()).addUrl("http://www.yidianzixun.com/mp/content?id=34018837").thread(5).run();
		
	}*/
}
