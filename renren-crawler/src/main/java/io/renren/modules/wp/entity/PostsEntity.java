package io.renren.modules.wp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author lixin
 * @email 
 * @date 2017-09-18 10:39:55
 */
public class PostsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long postAuthor;
	//
	private Date postDate;
	//
	private Date postDateGmt;
	//
	private String postContent;
	//
	private String postTitle;
	//
	private String postExcerpt;
	//
	private String postStatus;
	//
	private String commentStatus;
	//
	private String pingStatus;
	//
	private String postPassword;
	//
	private String postName;
	//
	private String toPing;
	//
	private String pinged;
	//
	private Date postModified;
	//
	private Date postModifiedGmt;
	//
	private String postContentFiltered;
	//
	private Long postParent;
	//
	private String guid;
	//
	private Integer menuOrder;
	//
	private String postType;
	//
	private String postMimeType;
	//
	private Long commentCount;

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
	public void setPostAuthor(Long postAuthor) {
		this.postAuthor = postAuthor;
	}
	/**
	 * 获取：
	 */
	public Long getPostAuthor() {
		return postAuthor;
	}
	/**
	 * 设置：
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	/**
	 * 获取：
	 */
	public Date getPostDate() {
		return postDate;
	}
	/**
	 * 设置：
	 */
	public void setPostDateGmt(Date postDateGmt) {
		this.postDateGmt = postDateGmt;
	}
	/**
	 * 获取：
	 */
	public Date getPostDateGmt() {
		return postDateGmt;
	}
	/**
	 * 设置：
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	/**
	 * 获取：
	 */
	public String getPostContent() {
		return postContent;
	}
	/**
	 * 设置：
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	/**
	 * 获取：
	 */
	public String getPostTitle() {
		return postTitle;
	}
	/**
	 * 设置：
	 */
	public void setPostExcerpt(String postExcerpt) {
		this.postExcerpt = postExcerpt;
	}
	/**
	 * 获取：
	 */
	public String getPostExcerpt() {
		return postExcerpt;
	}
	/**
	 * 设置：
	 */
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	/**
	 * 获取：
	 */
	public String getPostStatus() {
		return postStatus;
	}
	/**
	 * 设置：
	 */
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	/**
	 * 获取：
	 */
	public String getCommentStatus() {
		return commentStatus;
	}
	/**
	 * 设置：
	 */
	public void setPingStatus(String pingStatus) {
		this.pingStatus = pingStatus;
	}
	/**
	 * 获取：
	 */
	public String getPingStatus() {
		return pingStatus;
	}
	/**
	 * 设置：
	 */
	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}
	/**
	 * 获取：
	 */
	public String getPostPassword() {
		return postPassword;
	}
	/**
	 * 设置：
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	/**
	 * 获取：
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * 设置：
	 */
	public void setToPing(String toPing) {
		this.toPing = toPing;
	}
	/**
	 * 获取：
	 */
	public String getToPing() {
		return toPing;
	}
	/**
	 * 设置：
	 */
	public void setPinged(String pinged) {
		this.pinged = pinged;
	}
	/**
	 * 获取：
	 */
	public String getPinged() {
		return pinged;
	}
	/**
	 * 设置：
	 */
	public void setPostModified(Date postModified) {
		this.postModified = postModified;
	}
	/**
	 * 获取：
	 */
	public Date getPostModified() {
		return postModified;
	}
	/**
	 * 设置：
	 */
	public void setPostModifiedGmt(Date postModifiedGmt) {
		this.postModifiedGmt = postModifiedGmt;
	}
	/**
	 * 获取：
	 */
	public Date getPostModifiedGmt() {
		return postModifiedGmt;
	}
	/**
	 * 设置：
	 */
	public void setPostContentFiltered(String postContentFiltered) {
		this.postContentFiltered = postContentFiltered;
	}
	/**
	 * 获取：
	 */
	public String getPostContentFiltered() {
		return postContentFiltered;
	}
	/**
	 * 设置：
	 */
	public void setPostParent(Long postParent) {
		this.postParent = postParent;
	}
	/**
	 * 获取：
	 */
	public Long getPostParent() {
		return postParent;
	}
	/**
	 * 设置：
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	/**
	 * 获取：
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * 设置：
	 */
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	/**
	 * 获取：
	 */
	public Integer getMenuOrder() {
		return menuOrder;
	}
	/**
	 * 设置：
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}
	/**
	 * 获取：
	 */
	public String getPostType() {
		return postType;
	}
	/**
	 * 设置：
	 */
	public void setPostMimeType(String postMimeType) {
		this.postMimeType = postMimeType;
	}
	/**
	 * 获取：
	 */
	public String getPostMimeType() {
		return postMimeType;
	}
	/**
	 * 设置：
	 */
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：
	 */
	public Long getCommentCount() {
		return commentCount;
	}
}
