package io.renren.modules.wp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-22 14:48:10
 */
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String userLogin;
	//
	private String userPass;
	//
	private String userNicename;
	//
	private String userEmail;
	//
	private String userUrl;
	//
	private Date userRegistered;
	//
	private String userActivationKey;
	//
	private Integer userStatus;
	//
	private String displayName;

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
	 * 设置：
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	/**
	 * 获取：
	 */
	public String getUserLogin() {
		return userLogin;
	}
	/**
	 * 设置：
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	/**
	 * 获取：
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * 设置：
	 */
	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}
	/**
	 * 获取：
	 */
	public String getUserNicename() {
		return userNicename;
	}
	/**
	 * 设置：
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * 获取：
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * 设置：
	 */
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	/**
	 * 获取：
	 */
	public String getUserUrl() {
		return userUrl;
	}
	/**
	 * 设置：
	 */
	public void setUserRegistered(Date userRegistered) {
		this.userRegistered = userRegistered;
	}
	/**
	 * 获取：
	 */
	public Date getUserRegistered() {
		return userRegistered;
	}
	/**
	 * 设置：
	 */
	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}
	/**
	 * 获取：
	 */
	public String getUserActivationKey() {
		return userActivationKey;
	}
	/**
	 * 设置：
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * 获取：
	 */
	public String getDisplayName() {
		return displayName;
	}
}
