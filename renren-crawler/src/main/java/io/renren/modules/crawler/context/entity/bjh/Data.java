package io.renren.modules.crawler.context.entity.bjh;

import java.util.List;

public class Data {
	private int total;

	private int count;

	private List<Items> items;

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return this.total;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public List<Items> getItems() {
		return this.items;
	}
}
