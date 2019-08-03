package com.briup.bean;

public class Department {
	private String id;//部门编号
	private String name;//部门名称
	private String describe;//部门描述信息
	private int empCount;//员工总个数
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", describe="
				+ describe + ", empCount=" + empCount + "]";
	}
}
