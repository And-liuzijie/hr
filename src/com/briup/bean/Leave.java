package com.briup.bean;

import java.util.Date;

public class Leave {
    private String id;

    private String empid;

    private Date strattime;

    private Date endtime;

    private String reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    public Date getStrattime() {
        return strattime;
    }

    public void setStrattime(Date strattime) {
        this.strattime = strattime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}