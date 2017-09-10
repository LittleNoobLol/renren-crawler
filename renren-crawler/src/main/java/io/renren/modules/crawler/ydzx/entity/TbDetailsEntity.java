package io.renren.modules.crawler.ydzx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author xin
 * @email 531968207@qq.com
 * @date 2017-09-05 10:17:11
 */
public class TbDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 作者id
	private Integer authorId;
	// 正文内容带html标签
	private String contextHtml;
	// 正文内容
	private String contextText;
	// 分类
	private String ctype;
	// 发布时间
	private Date date;
	// 加密后url后缀
	private String docid;
	// 暂时未知分类
	private Integer dtype;
	// 本文所拥有的图片
	private String images;
	// 简介
	private String summary;
	// 标题
	private String title;
	// 未加密的完整url
	private String url;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：作者id
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * 获取：作者id
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * 设置：正文内容带html标签
	 */
	public void setContextHtml(String contextHtml) {
		this.contextHtml = contextHtml;
	}

	/**
	 * 获取：正文内容带html标签
	 */
	public String getContextHtml() {
		return contextHtml;
	}

	/**
	 * 设置：正文内容
	 */
	public void setContextText(String contextText) {
		this.contextText = contextText;
	}

	/**
	 * 获取：正文内容
	 */
	public String getContextText() {
		return contextText;
	}

	/**
	 * 设置：分类
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	/**
	 * 获取：分类
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * 设置：发布时间
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 获取：发布时间
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 设置：加密后url后缀
	 */
	public void setDocid(String docid) {
		this.docid = docid;
	}

	/**
	 * 获取：加密后url后缀
	 */
	public String getDocid() {
		return docid;
	}

	/**
	 * 设置：暂时未知分类
	 */
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}

	/**
	 * 获取：暂时未知分类
	 */
	public Integer getDtype() {
		return dtype;
	}

	/**
	 * 设置：本文所拥有的图片
	 */
	public void setImages(String images) {
		this.images = images;
	}

	/**
	 * 获取：本文所拥有的图片
	 */
	public String getImages() {
		return images;
	}

	/**
	 * 设置：简介
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 获取：简介
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：未加密的完整url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取：未加密的完整url
	 */
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "TbDetailsEntity [id=" + id + ", authorId=" + authorId + ", contextHtml=" + contextHtml
				+ ", contextText=" + contextText + ", ctype=" + ctype + ", date=" + date + ", docid=" + docid
				+ ", dtype=" + dtype + ", images=" + images + ", summary=" + summary + ", title=" + title + ", url="
				+ url + "]";
	}
	
	
}
