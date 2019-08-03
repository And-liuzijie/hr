package com.briup.service;

import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.PageInfo;
import com.briup.util.exception.ServiceException;

public interface IDepartmentService {
	/**
	 * 保存部门信息
	 * @param depart
	 * @throws ServiceException
	 */
	public void saveOrUpdateDepartement(Department depart) throws ServiceException;
	/**
	 * 获取部门列表信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws ServiceException
	 */
	public PageInfo<Department> getDepartWithCount(int currentPage,int pageSize) throws ServiceException;
	public List<Department> getAllDepart() throws ServiceException;
}
