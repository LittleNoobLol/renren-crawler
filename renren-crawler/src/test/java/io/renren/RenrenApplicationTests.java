package io.renren;

import io.renren.common.request.constant.HeaderConstant;
import io.renren.common.request.constant.UrlConstant;
import io.renren.common.request.constant.UserAgentConstant;
import io.renren.common.request.httpclient.HttpClientUtil;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.crawler.util.XinlangLogin;
import io.renren.modules.sys.entity.SysUserEntity;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenrenApplicationTests {
/*	@Autowired
	private RedisUtils redisUtils;
*/
	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) throws Exception {
		XinlangLogin.login(HeaderConstant.base_html, "18503085991", "xinlang0.0");
		System.out.println("登陆成功,Cookie:"+HeaderConstant.base_html.get("Cookie"));
		HeaderConstant.putUserAgent(HeaderConstant.base_html, UserAgentConstant.mobile_wap);
		HeaderConstant.putHost(HeaderConstant.base_html,"m.weibo.cn");
		HeaderConstant.base_html.put("Referer", "https://m.weibo.cn/p/102803_ctg1_8999_-_ctg1_8999_home");
	}
}
