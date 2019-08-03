package com.briup.dao;

import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.PageInfo;
import com.briup.util.exception.DataAccessException;

public interface IDepartmentDao {
	public void saveDepartment(Department department) throws DataAccessException;
	public Department getDepartById(String id) throws DataAccessException;
	public int updateDepartment(Department department) throws DataAccessException;
	public List<Department> findAllDepart() throws DataAccessException;
	public PageInfo<Department> getAllDepartWithEmpCount(int currentPage,int pageSize) throws DataAccessException;
}
