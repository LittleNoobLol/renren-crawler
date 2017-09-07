/**
  * Copyright 2017 bejson.com 
  */
package io.renren.modules.crawler.ydzx.common.entity;

import java.util.List;

public class Result {

	private String date;
	private String title;
	private String docid;
	private String meta;
	private String ctype;
	private int dtype;
	private String impid;
	private String pageid;
	private String itemid;
	private String channel_id;
	private int display_flag;
	private boolean feedback_forbidden;
	private List<String> tags;
	private String summary;
	private List<String> image_urls;
	private String source;
	private String url;
	private String category;
	private String image;
	private boolean auth;
	private boolean is_gov;
	private String content_type;
	private boolean b_political;
	private int title_sn;
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDocid() {
		return docid;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getMeta() {
		return meta;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCtype() {
		return ctype;
	}

	public void setDtype(int dtype) {
		this.dtype = dtype;
	}

	public int getDtype() {
		return dtype;
	}

	public void setImpid(String impid) {
		this.impid = impid;
	}

	public String getImpid() {
		return impid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public String getPageid() {
		return pageid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemid() {
		return itemid;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setDisplay_flag(int display_flag) {
		this.display_flag = display_flag;
	}

	public int getDisplay_flag() {
		return display_flag;
	}

	public void setFeedback_forbidden(boolean feedback_forbidden) {
		this.feedback_forbidden = feedback_forbidden;
	}

	public boolean getFeedback_forbidden() {
		return feedback_forbidden;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public void setImage_urls(List<String> image_urls) {
		this.image_urls = image_urls;
	}

	public List<String> getImage_urls() {
		return image_urls;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public boolean getAuth() {
		return auth;
	}

	public void setIs_gov(boolean is_gov) {
		this.is_gov = is_gov;
	}

	public boolean getIs_gov() {
		return is_gov;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setB_political(boolean b_political) {
		this.b_political = b_political;
	}

	public boolean getB_political() {
		return b_political;
	}

	public void setTitle_sn(int title_sn) {
		this.title_sn = title_sn;
	}

	public int getTitle_sn() {
		return title_sn;
	}

	@Override
	public String toString() {
		return "Result [date=" + date + ", title=" + title + ", docid=" + docid + ", meta=" + meta + ", ctype=" + ctype
				+ ", dtype=" + dtype + ", impid=" + impid + ", pageid=" + pageid + ", itemid=" + itemid
				+ ", channel_id=" + channel_id + ", display_flag=" + display_flag + ", feedback_forbidden="
				+ feedback_forbidden + ", tags=" + tags + ", summary=" + summary + ", image_urls=" + image_urls
				+ ", source=" + source + ", url=" + url + ", category=" + category + ", image=" + image + ", auth="
				+ auth + ", is_gov=" + is_gov + ", content_type=" + content_type + ", b_political=" + b_political
				+ ", title_sn=" + title_sn + "]";
	}

	
}
