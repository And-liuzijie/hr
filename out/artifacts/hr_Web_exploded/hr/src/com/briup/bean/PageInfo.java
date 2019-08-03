package com.briup.bean;

import java.util.List;

public class PageInfo<T>{
	private int pageCount;//总页数
	private int totle;//总个数
	private int size;//每页大小
	private int currentPage;//当前页
	private List<T> pageInfos;
	public int getPageCount() {
		pageCount = (totle%size==0)?totle/size:totle/size+1;
		return pageCount;
	}
	public List<T> getPageInfos() {
		return pageInfos;
	}
	public void setPageInfos(List<T> pageInfos) {
		this.pageInfos = pageInfos;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotle() {
		return totle;
	}
	public void setTotle(int totle) {
		this.totle = totle;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
