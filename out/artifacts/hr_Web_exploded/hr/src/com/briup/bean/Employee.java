package com.briup.bean;

import java.util.Date;

public class Employee {
	private String id;
	private String name;
	private String password;
	private String gender;
	private Date birthday;
	private String email;
	private String deptID;//部门编号
	private Department department;
	private String impRole; //职位
	private double salary;
	private String tel;
	private String info;
	private int implState; //在职状态
	public Employee() {
	}
	public Employee(String id){
		this.id = id;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeptID() {
		return deptID;
	}
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	public String getImpRole() {
		return impRole;
	}
	public void setImpRole(String impRole) {
		this.impRole = impRole;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getImplState() {
		return implState;
	}
	public void setImplState(int implState) {
		this.implState = implState;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", email=" + email + ", deptID="
				+ deptID + ", impRole=" + impRole + ", salary=" + salary
				+ ", tel=" + tel + ", info=" + info + ", implState="
				+ implState + ","+department+"]";
	}
}
