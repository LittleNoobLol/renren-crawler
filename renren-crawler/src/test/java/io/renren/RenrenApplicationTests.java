package io.renren;

import io.renren.common.utils.RedisUtils;

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
	public void contextLoads() {
	}

}
