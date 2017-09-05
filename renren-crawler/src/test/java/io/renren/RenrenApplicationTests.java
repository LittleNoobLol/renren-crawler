package io.renren;

import io.renren.common.request.httpclient.HttpClientUtil;
import io.renren.common.utils.RedisUtils;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;

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

	@Test
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
				TbDetailsEntity comileDetail = EntityCompile.comileDetail(html);
				comileDetail.setId(i);
				comileDetail.setUrl(url);
				service.save(comileDetail);
				System.out.println("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void contextLoads() {
	}

}
