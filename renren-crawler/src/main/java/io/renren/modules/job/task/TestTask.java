package io.renren.modules.job.task;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.ydzx.common.EntityCompile;
import io.renren.modules.crawler.ydzx.common.Header;
import io.renren.modules.crawler.ydzx.entity.TbDetailsEntity;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * testTask为spring bean的名称
 * 
 */
@Component("testTask")
public class TestTask {
	
	@Autowired
	private TbDetailsService service;
	

	@Value("${image.savepath}")
	private String savePath;

	public void test(String params) {
		int count = 100;
		try {
			// 尝试转换值
			count=Integer.valueOf(params);
		} catch (Exception e) {
		}
		
		boolean flag=true;
		int success = 0;
		// 获取上次的id
		int queryMaxId = service.queryMaxId();
		while(flag){
			queryMaxId++;
			try {
				String url = Url.getDetail(queryMaxId);
				String html = HttpClientUtil.get(url, Header.header);
				Document doc=Jsoup.parse(html);
				TbDetailsEntity detail = EntityCompile.comileDetail(doc, url);
				
				boolean save = service.save(detail);
				if(save){
					success++;
				}
				
				// 下载图片
				List<String> images = EntityCompile.getImages(doc);
				if (images != null && images.size() > 0) {
					for (String imgUrl : images) {
						try {
							String fileName = imgUrl.substring(imgUrl.lastIndexOf("=") + 1, imgUrl.length());
							HttpClientUtil.download(imgUrl, Header.header, savePath, fileName);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				//e.printStackTrace();
				//System.out.println(",保存失败");
			}
			// 如果数据已经抓取完毕了,就退出循环
			if(success >= count){
				flag = false;
			}
		}
	}

}
