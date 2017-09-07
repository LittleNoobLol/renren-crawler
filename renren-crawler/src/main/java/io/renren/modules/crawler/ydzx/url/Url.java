package io.renren.modules.crawler.ydzx.url;

public class Url {

	/**
	 * 
	 * @Description 作者专栏模块
	 * @author lixin
	 * @date 2017年9月4日
	 * @param id
	 * @return 作者的所写的文章json
	 */
	public static String getAuthor(int id, int strat) {
		StringBuffer sb = new StringBuffer("http://www.yidianzixun.com/home/q/news_list_for_channel?channel_id=m");
		sb.append(id);
		sb.append("&cstart=" + strat + "&cend=" + (strat + 10));
		sb.append("&infinite=true&refresh=1&__from__=pc&multi=5&appid=web_yidian&_=");
		sb.append(System.currentTimeMillis());
		return sb.toString();
	}

	/***
	 * 
	 * @Description 获取详情页面信息
	 * @author lixin
	 * @date 2017年9月5日
	 * @param id
	 * @return
	 */
	public static String getDetail(long id) {
		return "http://www.yidianzixun.com/mp/content?id=" + id;
	}

	/***
	 * 
	 * @Description 获取最新的信息列表
	 * @author lixin
	 * @date 2017年9月8日
	 * @return
	 */
	public static String getDeatil() {
		return "http://www.yidianzixun.com/home/q/news_list_for_channel?channel_id=best&cstart=0&cend=10&infinite=true&refresh=1&__from__=pc&multi=5&appid=web_yidian&_="
				+ System.currentTimeMillis();
	}

}
