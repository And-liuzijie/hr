package com.briup.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.PageInfo;
import com.briup.dao.DBUtils;
import com.briup.dao.IDepartmentDao;
import com.briup.dao.impl.DepartmentDaoImpl;
import com.briup.service.IDepartmentService;
import com.briup.util.exception.DataAccessException;
import com.briup.util.exception.ServiceException;

public class DepartmentServiceImpl implements IDepartmentService {
	private IDepartmentDao departDao = new DepartmentDaoImpl();
	@Override
	public void saveOrUpdateDepartement(Department depart) throws ServiceException {
		try {
			Department d = departDao.getDepartById(depart.getId());
			if(d==null){
				departDao.saveDepartment(depart);
			}else{
				departDao.updateDepartment(depart);
			}
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

	public PageInfo<Department> getDepartWithCount(int currentPage,int pageSize) throws ServiceException{
		try {
			return departDao.getAllDepartWithEmpCount(currentPage, pageSize);
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
	public List<Department> getAllDepart() throws ServiceException {
		try {
			return departDao.findAllDepart();
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
}
