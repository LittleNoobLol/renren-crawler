package io.renren.modules.crawler.ydzx.common.entity;

import java.util.List;

public class Author {

	/**
	 * 返回状态: 正常:success
	 */
	public String status;

	/**
	 * 返回状态: 正常:0
	 */
	public int code;

	/***
	 * 文章列表
	 */
	private List<Result> result;

	/**
	 * 作者信息
	 */
	private Channel_media channel_media;

	public int fresh_count;

	/**
	 * 空值信息
	 */
	public String reason;

	public int disable_op;
	/***
	 * 多少人订阅: 5388人订阅
	 */
	public String bookcount;
	/***
	 * m391627
	 */
	public String channel_id;
	/***
	 * m391627
	 */
	public String fromId;
	/***
	 * 作者名称:杨澜
	 */
	public String channel_name;

	/***
	 * 作者类型: media
	 */
	public String channel_type;

	/***
	 * 作者标题: 资深传媒人士，阳光媒体集团董事局主席
	 */
	public String channel_summary;

	/***
	 * 作者头像:路径
	 */
	public String channel_image;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public Channel_media getChannel_media() {
		return channel_media;
	}

	public void setChannel_media(Channel_media channel_media) {
		this.channel_media = channel_media;
	}

	public int getFresh_count() {
		return fresh_count;
	}

	public void setFresh_count(int fresh_count) {
		this.fresh_count = fresh_count;
	}

	public int getDisable_op() {
		return disable_op;
	}

	public void setDisable_op(int disable_op) {
		this.disable_op = disable_op;
	}

	public String getBookcount() {
		return bookcount;
	}

	public void setBookcount(String bookcount) {
		this.bookcount = bookcount;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public String getChannel_type() {
		return channel_type;
	}

	public void setChannel_type(String channel_type) {
		this.channel_type = channel_type;
	}

	public String getChannel_summary() {
		return channel_summary;
	}

	public void setChannel_summary(String channel_summary) {
		this.channel_summary = channel_summary;
	}

	public String getChannel_image() {
		return channel_image;
	}

	public void setChannel_image(String channel_image) {
		this.channel_image = channel_image;
	}

	@Override
	public String toString() {
		return "Athor [status=" + status + ", code=" + code + ", result=" + result + ", channel_media=" + channel_media
				+ ", fresh_count=" + fresh_count + ", disable_op=" + disable_op + ", bookcount=" + bookcount
				+ ", channel_id=" + channel_id + ", fromId=" + fromId + ", channel_name=" + channel_name
				+ ", channel_type=" + channel_type + ", channel_summary=" + channel_summary + ", channel_image="
				+ channel_image + "]";
	}

}
