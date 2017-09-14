package io.renren;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.common.Page;
import io.renren.common.utils.RedisUtils;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
import us.codecraft.webmagic.Spider;
import io.renren.modules.crawler.ydzx.common.DetailMagic;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.common.YdzxCommon;
import io.renren.modules.crawler.ydzx.common.entity.NewsJson;
import io.renren.modules.crawler.ydzx.common.entity.Result;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenrenApplicationTests {

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private TbDetailsService service;

	public void detail() {
		TbDetailsService service = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");

		for (int i = 33475316; i >= 666666; i--) {
			if (i % 30000 == 0) {
				service = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
			}
			try {
				String url = Url.getDetail(i);
				System.out.print("当前是" + url + ",");
				String html = HttpClientUtil.get(url, Header.header);
				TbDetailsEntity comileDetail = EntityCompile.comileDetail(html, i);
				comileDetail.setId(i);
				comileDetail.setUrl(url);
				service.save(comileDetail);
				System.out.println("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void newJob() {
		// 获取链接对象
		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		int start = detailService.queryMaxId() + 1;
		int end = start + 30;
		// 创建magic爬虫
		Spider create = Spider.create(new DetailMagic());
		// 添加url
		for (int i = start; i <= end; i++) {
			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);
		}
		// 设置线程数并启动
		create.thread(30).run();
	}

	public void job() {
		int end = YdzxCommon.getNewsId(1);
		// 获取链接对象
		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		int start = detailService.queryMaxId();

		// 创建对象
		TbDetailsEntity entit = new TbDetailsEntity();
		// 获取最新的id
		entit.setId(end);
		// 保存数据库,防止其他线程再次访问
		detailService.save(entit);

		// 创建magic爬虫
		Spider create = Spider.create(new DetailMagic());
		// 添加url
		for (int i = 35070533; i <= 35070733; i++) {
			if (i % 10000 == 0) {
				create.thread(50).run();
				detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
				create = Spider.create(new DetailMagic());
			}
			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);

		}
		// 设置线程数并启动
		create.thread(50).run();
	}

	public void contextLoads() {
		try {
			List<TbDetailsEntity> queryList = service.queryList(null);
			for (TbDetailsEntity entity : queryList) {
				String html = entity.getContextHtml();
				Document document = Jsoup.parse(html);
				Elements select = document.select("img");
				for (Element element : select) {
					String attr = element.attr("src");
					boolean download = HttpClientUtil.download(attr, Header.header, "D:\\",
							attr.substring(34, 44) + ".png");
					if (download)
						System.out.println("下载成功");
					else
						System.out.println(attr + "下载失败");
				}
				System.out.println();
			}

			/*	*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
