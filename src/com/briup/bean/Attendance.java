package com.briup.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 签到类
 * */
public class Attendance {
	
    private String id;
    /**
     * 签到日期
     * */
    private Date attendTime;
    /**
     * 签到状态<Br>
     * 1 : 已经签到<br>
     * 2 : 已经签到，并且是今天<Br>
     * */
    private BigDecimal attendState;
    /**
     * 该条签到信息对应的员工是谁<Br>
     * 这个属性值是员工id
     * */
    private String empId;

    private  Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public BigDecimal getAttendState() {
        return attendState;
    }

    public void setAttendState(BigDecimal attendState) {
        this.attendState = attendState;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }
}