package com.briup.bean;

import java.util.Date;

public class Attendance {
	private Employee emp;
	private Date attendTime;
	private int attendState;
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Date getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(Date attendTime) {
		this.attendTime = attendTime;
	}
	public int getAttendState() {
		return attendState;
	}
	public void setAttendState(int attendState) {
		this.attendState = attendState;
	}
	@Override
	public String toString() {
		return "Attendance [emp=" + emp + ", attendTime=" + attendTime
				+ ", attendState=" + attendState + "]";
	}
}
