package com.briup.service;

import java.util.List;

import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.util.exception.ServiceException;

public interface IEmployeeService {
	public void addNewEmp(Employee emp) throws ServiceException;
	public List<Employee> getEmpsByPage(int currentPage,int pageSize) throws ServiceException;
	public Employee getEmpsById(String id) throws ServiceException;
	public void updateEmp(Employee emp)throws ServiceException;
	public int getPageCount(int pageSize) throws ServiceException;
	public PageInfo<Employee> getEmployees(String deptName,String username,String empId,
			double downSalary,double upSalary,int cPage,int size) throws ServiceException;
	public Employee login(String userId,String password) throws ServiceException;
}
