package io.renren.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

	@Value("${image.savepath}")
	private String savePath;

	@Value("${image.ydzxreplace}")
	private String ydzxReplace;

	@Value("${image.myself}")
	private String myself;
	
	@Test
	public void readConfig(){
		
		System.out.println(savePath);
		System.out.println(ydzxReplace);
		System.out.println(myself);
	}
}
