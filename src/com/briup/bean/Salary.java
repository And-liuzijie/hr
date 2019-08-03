package com.briup.bean;

public class Salary {
    private String id;

    private  Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {

        return employee;
    }

    private String empid;

    private String year;

    private String mon;

    private Integer basicsalary;

    private Integer etrasalary;

    private Integer holidaysalary;

    private Integer outsalary;

    private Integer totalSalary;

    public Integer getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Integer totalSalary) {

        this.totalSalary = totalSalary;
    }



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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon == null ? null : mon.trim();
    }

    public Integer getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Integer getEtrasalary() {
        return etrasalary;
    }

    public void setEtrasalary(Integer etrasalary) {
        this.etrasalary = etrasalary;
    }

    public Integer getHolidaysalary() {
        return holidaysalary;
    }

    public void setHolidaysalary(Integer holidaysalary) {
        this.holidaysalary = holidaysalary;
    }

    public Integer getOutsalary() {
        return outsalary;
    }

    public void setOutsalary(Integer outsalary) {
        this.outsalary = outsalary;
    }
}