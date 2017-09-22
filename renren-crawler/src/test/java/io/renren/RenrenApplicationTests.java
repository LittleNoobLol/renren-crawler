package io.renren;

import io.renren.modules.crawler.common.HttpClientUtil;
import io.renren.modules.crawler.common.Page;
import io.renren.common.utils.RedisUtils;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.crawler.ydzx.service.TbDetailsService;
import io.renren.modules.crawler.ydzx.url.Url;
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


}
