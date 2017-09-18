package io.renren.wp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.wp.service.PostsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublishTest {
	
	@Autowired
	private PostsService service;
	
	/***
	 * 测试发布方法
	 */
	@Test
	public void publis(){
		TbDetailsEntity detail=new TbDetailsEntity();
		detail.setContextHtml("<p><span><a href=\"/channel/w/top\">top</a>men.com.cn</span></p>");
		detail.setTitle("TOP街拍丨看TOP粉们来晒鞋，最受欢迎的居然是它！！！");
		service.publish(detail);
	}
	
	public void queyMaxId(){
		int queryMaxId = service.queryMaxId();
		System.out.println(queryMaxId);
	}

}
