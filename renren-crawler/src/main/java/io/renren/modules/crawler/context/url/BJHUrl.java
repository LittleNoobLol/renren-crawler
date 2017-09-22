package io.renren.modules.crawler.context.url;

public class BJHUrl {

	public static String getList(int limit,int skip){
		return "https://baijia.baidu.com/listarticle?ajax=json&_limit="+limit+"&_skip="+skip+"&quality=1&_desc=top_st%2Cupdated_at";
	}
	
}
