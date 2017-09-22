package io.renren.modules.crawler.context.entity.bjh;

public class ListJson {
	private int errno;

	private String request_id;

	private int timestamp;

	private Data data;

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public int getErrno() {
		return this.errno;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getRequest_id() {
		return this.request_id;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return this.data;
	}
}
