package io.renren.modules.crawler.ydzx.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-11 19:55:33
 */
public class CountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//成功数量
	private Integer successNum;
	//
	private Integer errorNum;
	//跳过的数量
	private Integer skipNum;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：成功数量
	 */
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
	/**
	 * 获取：成功数量
	 */
	public Integer getSuccessNum() {
		return successNum;
	}
	/**
	 * 设置：
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}
	/**
	 * 获取：
	 */
	public Integer getErrorNum() {
		return errorNum;
	}
	/**
	 * 设置：跳过的数量
	 */
	public void setSkipNum(Integer skipNum) {
		this.skipNum = skipNum;
	}
	/**
	 * 获取：跳过的数量
	 */
	public Integer getSkipNum() {
		return skipNum;
	}
}
