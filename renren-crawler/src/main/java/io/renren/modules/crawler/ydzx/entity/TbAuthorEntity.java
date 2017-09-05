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
public class TbAuthorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//订阅人数
	private Integer bookCount;
	//头像url
	private String channelImage;
	//姓名
	private String channelName;
	//简介
	private String channelSummary;
	//父类型
	private String channelType;
	//子类型
	private String mediaDomain;

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
	 * 设置：订阅人数
	 */
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	/**
	 * 获取：订阅人数
	 */
	public Integer getBookCount() {
		return bookCount;
	}
	/**
	 * 设置：头像url
	 */
	public void setChannelImage(String channelImage) {
		this.channelImage = channelImage;
	}
	/**
	 * 获取：头像url
	 */
	public String getChannelImage() {
		return channelImage;
	}
	/**
	 * 设置：姓名
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * 获取：姓名
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * 设置：简介
	 */
	public void setChannelSummary(String channelSummary) {
		this.channelSummary = channelSummary;
	}
	/**
	 * 获取：简介
	 */
	public String getChannelSummary() {
		return channelSummary;
	}
	/**
	 * 设置：父类型
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * 获取：父类型
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * 设置：子类型
	 */
	public void setMediaDomain(String mediaDomain) {
		this.mediaDomain = mediaDomain;
	}
	/**
	 * 获取：子类型
	 */
	public String getMediaDomain() {
		return mediaDomain;
	}
}
