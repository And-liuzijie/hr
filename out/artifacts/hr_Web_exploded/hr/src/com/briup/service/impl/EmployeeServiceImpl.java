package com.briup.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.dao.DBUtils;
import com.briup.dao.IEmployeeDao;
import com.briup.dao.impl.EmployeeDaoImpl;
import com.briup.service.IEmployeeService;
import com.briup.util.exception.DataAccessException;
import com.briup.util.exception.ServiceException;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao empDao = new EmployeeDaoImpl();
	public void addNewEmp(Employee emp) throws ServiceException {
		try {
			empDao.saveEmployee(emp);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}finally{
			try {
				DBUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<Employee> getEmpsByPage(int currentPage, int pageSize)
			throws ServiceException {
		try {
			return empDao.getEmployeeByPage(currentPage, pageSize);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}finally{
			try {
				DBUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public Employee getEmpsById(String id) throws ServiceException {
		try {
			return empDao.getEmpById(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} finally{
			try {
				DBUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void updateEmp(Employee emp) throws ServiceException {
		try {
			empDao.updateEmployee(emp);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} finally {
			try {
				DBUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public int getPageCount(int pageSize) throws ServiceException {
		try {
			int count = empDao.getEmpCount();
			int pageCount = count/pageSize;
			if(count%pageSize!=0){
				pageCount++;
			}
			return pageCount;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 1;
	}
	@Override
	public PageInfo<Employee> getEmployees(String deptName, String username,
			String empId, double downSalary, double upSalary,int cPage,int size)
			throws ServiceException {
		try {
			PageInfo<Employee> list = empDao.findEmpsByCondition(deptName, username,
					empId, downSalary, upSalary,cPage,size);
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	@Override
	public Employee login(String userID, String password)
			throws ServiceException {
		try {
			Employee emp = empDao.getEmpById(userID);
			if(emp==null){
				throw new ServiceException("请确认职工编号和密码是否正确！");
			}
			if(!password.equals(emp.getPassword())){
				throw new ServiceException("请确认职工编号和密码是否正确！");
			}
			return emp;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
}
