package com.briup.dao;

import java.util.List;

import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.util.exception.DataAccessException;

public interface IEmployeeDao {
	/**
	 * 保存员工信息
	 * @param emp	要添加的员工信息
	 * @throws DataAccessException
	 */
	public void saveEmployee(Employee emp) throws DataAccessException;
	/**
	 * 获取指定页的员工信息
	 * @param currentPage	当前页
	 * @param pageSize		每页显示多少个
	 * @return	返回查找到的所有员工信息
	 * @throws DataAccessException
	 */
	public List<Employee> getEmployeeByPage(int currentPage,int pageSize)throws DataAccessException;
	/**
	 * 获取员工总数
	 * @return	获取所有员工总数
	 * @throws DataAccessException
	 */
	public int getEmpCount() throws DataAccessException;
	/**
	 * 查找指定编号的员工信息
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public Employee getEmpById(String id) throws DataAccessException;
	public void updateEmployee(Employee emp) throws DataAccessException;
	public PageInfo<Employee> findEmpsByCondition(String deptName,String username,
			String empId,double downSalary,double upSalary,int currentPage,int size)throws DataAccessException;
}
