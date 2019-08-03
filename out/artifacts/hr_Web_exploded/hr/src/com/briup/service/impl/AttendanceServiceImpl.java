package com.briup.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.briup.bean.Attendance;
import com.briup.dao.DBUtils;
import com.briup.dao.IAttendanceDao;
import com.briup.dao.impl.AttendanceDaoImpl;
import com.briup.service.IAttendanceService;
import com.briup.util.exception.DataAccessException;
import com.briup.util.exception.ServiceException;

public class AttendanceServiceImpl implements IAttendanceService {
	private IAttendanceDao attenDao = new AttendanceDaoImpl();
	@Override
	public List<Attendance> findEmpAttend(String empid, String date)
			throws ServiceException {
		try {
			return attenDao.findEmpAttendanceThisMonth(empid, date);
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
	public void qianDao(Attendance attendance) throws ServiceException {
		try {
			attenDao.insertAttendance(attendance);
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

}
