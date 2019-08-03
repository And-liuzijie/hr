package com.briup.dao;

import java.util.List;

import com.briup.bean.Attendance;
import com.briup.util.exception.DataAccessException;

public interface IAttendanceDao {
	public List<Attendance> findEmpAttendanceThisMonth(String empId,String date)throws DataAccessException;
	public void insertAttendance(Attendance attendance)throws DataAccessException;
	
}
