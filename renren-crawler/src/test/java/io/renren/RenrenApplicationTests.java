package io.renren;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.common.utils.RedisUtils;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
import us.codecraft.webmagic.Spider;
import io.renren.modules.crawler.ydzx.common.DetailMagic;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenrenApplicationTests {

	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private TbDetailsService service;

	public void detail() {
		TbDetailsService service = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");

		for (long i = 33475316; i >= 666666; i--) {
			if (i % 30000 == 0) {
				service = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
			}
			try {
				String url = Url.getDetail(i);
				System.out.print("当前是" + url + ",");
				String html = HttpClientUtil.get(url, Header.header);
				TbDetailsEntity comileDetail = EntityCompile.comileDetail(html,i);
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
	public void magicTest(){
		TbDetailsService detailService = (TbDetailsService) SpringContextUtils.getBean("tbDetailsService");
		Spider create = Spider.create(new DetailMagic(detailService));
		for (int i = 34018832; i < 34018851; i++) {
			create.addUrl("http://www.yidianzixun.com/mp/content?id=" + i);
		} 
		create.thread(5).run();
		
	}
	
	public void job() throws Exception{
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
	
	public void contextLoads() {
		try {
			List<TbDetailsEntity> queryList = service.queryList(null);
			for (TbDetailsEntity entity : queryList) {
				String html = entity.getContextHtml();
				Document document=Jsoup.parse(html);
				Elements select = document.select("img");
				for (Element element : select) {
					String attr = element.attr("src");
					boolean download = HttpClientUtil.download(attr, Header.header, "D:\\", attr.substring(34, 44)+".png");
					if(download)
						System.out.println("下载成功");
					else
						System.out.println(attr+"下载失败");
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
