package io.renren.common.request.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description 浏览器请求头
 * @author lixin
 * @date 2017年8月22日
 */
public class HeaderConstant {

	/**
	 * pc 基础请求 html 数据
	 */
	public static Map<String, String> base_html;

	/**
	 * pc 基础请求 json 数据
	 */
	public static Map<String, String> base_json;

	static {
		base_html = new HashMap<String, String>();
		base_html.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		base_html.put("Accept-Encoding", "gzip, deflate, sdch");
		base_html.put("Accept-Language", "zh-CN,zh;q=0.8");
		base_html.put("Cache-Control", "max-age=0");
		base_html.put("Connection", "keep-alive");

		base_json = new HashMap<String, String>();
		base_json.put("Accept", "application/json, text/plain, */*");
		base_json.put("Accept-Language", "zh-CN,zh;q=0.8");
		base_json.put("Connection", "keep-alive");
	}

	/**
	 * 放入cookie
	 * 
	 * @param base_head
	 * @param cookies
	 */
	public static void putCookie(Map<String, String> base_head, String cookies) {
		String cookie = base_head.get("Cookie");
		// 判断之前cookie是否为空
		if (null == cookie || "".equals(cookie)) {
			base_head.put("Cookie", cookies);
		} else {
			// 追加cookie内容
			cookie += "&" + cookies;
			base_head.put("Cookie", cookie);
		}
	}

	/**
	 * 新增请求头
	 * 
	 * @param base_head
	 * @param key
	 * @param value
	 */
	public static void putHead(Map<String, String> base_head, String key, String value) {
		base_head.put(key, value);
	}

}