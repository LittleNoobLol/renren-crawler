package io.renren.modules.crawler.context.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lixin
 * @email
 * @date 2017-09-22 14:45:30
 */
public class ContextEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ContextEntity(){
		
	}
	
	public ContextEntity(String bookId, Integer bookType,Date publishDate, String title) {
		this.bookId = bookId;
		this.bookType = bookType;
		this.publishDate = publishDate;
		this.title = title;
	}
	
	public ContextEntity(String bookId, Integer bookType, String context, Long authorId, Date publishDate, String title) {
		this.bookId = bookId;
		this.bookType = bookType;
		this.context = context;
		this.authorId = authorId;
		this.publishDate = publishDate;
		this.title = title;
	}

	// 编号
	private Long id;
	// 可能某些站点可以根据id进行查询,所以保留
	private String bookId;
	// 区分不同站点信息
	private Integer bookType;
	// 文章内容
	private String context;
	// 作者编号
	private Long authorId;
	// 文章的发布时间
	private Date publishDate;
	// 文章标题
	private String title;

	/**
	 * 设置：编号
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：编号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：可能某些站点可以根据id进行查询,所以保留
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * 获取：可能某些站点可以根据id进行查询,所以保留
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * 设置：区分不同站点信息
	 */
	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}

	/**
	 * 获取：区分不同站点信息
	 */
	public Integer getBookType() {
		return bookType;
	}

	/**
	 * 设置：文章内容
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * 获取：文章内容
	 */
	public String getContext() {
		return context;
	}

	/**
	 * 设置：作者编号
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
	 * 获取：作者编号
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * 设置：文章的发布时间
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：文章的发布时间
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：文章标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：文章标题
	 */
	public String getTitle() {
		return title;
	}
}
