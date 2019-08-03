package com.briup.service;

import java.util.List;

import com.briup.bean.Attendance;
import com.briup.util.exception.ServiceException;

public interface IAttendanceService {
	public List<Attendance> findEmpAttend(String empid,String date) throws ServiceException;
	public void qianDao(Attendance attendance) throws ServiceException;
}
