package io.renren.job;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.DateUtils;
import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.context.entity.ContextEntity;
import io.renren.modules.crawler.context.entity.bjh.Items;
import io.renren.modules.crawler.context.entity.bjh.ListJson;
import io.renren.modules.crawler.context.service.ContextService;
import io.renren.modules.crawler.context.url.BJHUrl;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.wp.service.UsersService;

/***
 * 统一模块化爬虫
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnfiyCrawler {

	@Autowired
	private ContextService contextService;

	@Autowired
	private UsersService userService;

	/**
	 * 百家号爬虫爬取
	 */
	@Test
	public void baijiahao() {
		boolean flag = true;
		int success = 0;
		int count = 100;
		int page = 1;
		while (flag) {
			try {
				String json = HttpClientUtil.get(BJHUrl.getList((page * 100), (page - 1) * 100), Header.header);
				ListJson parseObject = JSON.parseObject(json, ListJson.class);
				List<Items> items = parseObject.getData().getItems();
				for (Items t : items) {
					ContextEntity context = new ContextEntity("bjh_" + t.getId(), 1, DateUtils.parse(t.getPublish_at()),
							t.getTitle());
					Long authorId = userService.getAuthorId(t.getWriter_name());
					context.setAuthorId(authorId);
					contextService.save(context);
					success++;
					System.out.println("编号:" + t.getId() + ",时间:" + DateUtils.parse(t.getPublish_at()) + ",标题:"
							+ t.getTitle() + ",作者:" + t.getWriter_name());
				}
				if (count <= success) {
					flag = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			String json = HttpClientUtil.get(BJHUrl.getList(50, 0), Header.header);
			ListJson parseObject = JSON.parseObject(json, ListJson.class);
			List<Items> items = parseObject.getData().getItems();
			for (Items t : items) {
				ContextEntity context = new ContextEntity("bjh_" + t.getId(), 1, DateUtils.parse(t.getPublish_at()),
						t.getTitle());

				System.out.println("编号:" + t.getId() + ",时间:" + DateUtils.parse(t.getPublish_at()) + ",标题:"
						+ t.getTitle() + ",作者:" + t.getWriter_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
