package io.renren.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTest {


	@Autowired
	private TbDetailsService service;


	/**
	 * 最新需求,每天抓取100条数据
	 */
	@Test
	public void newJob() {
		boolean flag=true;
		int count = 0;
		// 获取上次的id
		int queryMaxId = service.queryMaxId();
		while(flag){
			queryMaxId++;
			try {
				String url = Url.getDetail(queryMaxId);
				System.out.print("當前url:"+url);
				String html = HttpClientUtil.get(url, Header.header);
				Document doc=Jsoup.parse(html);
				TbDetailsEntity detail = EntityCompile.comileDetail(doc, url);
				
				boolean save = service.save(detail);
				if(save){
					count++;
					System.out.println(",保存成功");
				}
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(",保存失败");
			}
			// 如果已经 抓取满100条了,就退出循环
			if(count >= 100){
				flag = false;
			}
		}
	}
}
