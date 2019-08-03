package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.briup.bean.Attendance;
import com.briup.bean.Employee;
import com.briup.dao.DBUtils;
import com.briup.dao.IAttendanceDao;
import com.briup.util.exception.DataAccessException;

public class AttendanceDaoImpl implements IAttendanceDao{
	@Override
	public List<Attendance> findEmpAttendanceThisMonth(String empId,String date) throws DataAccessException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			/*SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
			String now = sf.format(new Date());*/
			String sql = "select * from attendance where impId = '"+empId+"' "
					+ " and  to_char(attendTime,'yyyy-MM')='"+date+"'";
			System.out.println("sql : "+sql);
			rs = stmt.executeQuery(sql);
			List<Attendance> list = new ArrayList<>();
			while(rs.next()){
				Attendance ac = new Attendance();
				ac.setEmp(new Employee(rs.getString("impId")));
				ac.setAttendTime(rs.getDate("attendTime"));
				ac.setAttendState(rs.getInt("attendState"));
				System.out.println("attendance : "+ac);
				list.add(ac);
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		} finally {
			DBUtils.close(stmt, rs);
		}
	}

	@Override
	public void insertAttendance(Attendance attendance)
			throws DataAccessException {
		PreparedStatement pstmt = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "insert into attendance (impID,attendtime,attendstate) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, attendance.getEmp().getId());
			pstmt.setTimestamp(2,new java.sql.Timestamp(attendance.getAttendTime().getTime()));
			pstmt.setInt(3, attendance.getAttendState());
			pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		} finally {
			DBUtils.close(pstmt, null);
		}
	}
}
