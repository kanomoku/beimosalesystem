package com.pojo;

import java.util.List;

public class PageInfoAll{
	// 每页显示个数
	private int pageSize;
	// 当前第几页
	private int pageNum;
	// 总页数
	private Long total;
	// 当前页显示的数据
	private List<?> list;

	private String posYear;
	private String posMonth;
	private String posDay;

	public String getPosYear() {
		return posYear;
	}

	public void setPosYear(String posYear) {
		this.posYear = posYear;
	}

	public String getPosMonth() {
		return posMonth;
	}

	public void setPosMonth(String posMonth) {
		this.posMonth = posMonth;
	}

	public String getPosDay() {
		return posDay;
	}

	public void setPosDay(String posDay) {
		this.posDay = posDay;
	}

	public final int getPageSize() {
		return pageSize;
	}

	public final void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public final int getPageNum() {
		return pageNum;
	}

	public final void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public final Long getTotal() {
		return total;
	}

	public final void setTotal(Long total) {
		this.total = total;
	}

	public final List<?> getList() {
		return list;
	}

	public final void setList(List<?> list) {
		this.list = list;
	}

}
