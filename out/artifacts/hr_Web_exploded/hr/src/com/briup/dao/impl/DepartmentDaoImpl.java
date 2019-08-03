package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.PageInfo;
import com.briup.dao.DBUtils;
import com.briup.dao.IDepartmentDao;
import com.briup.util.exception.DataAccessException;

public class DepartmentDaoImpl implements IDepartmentDao {
	public void saveDepartment(Department department)
			throws DataAccessException {
		PreparedStatement pstmt = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "insert into department(departid,departname,departdescrip) "
					+ "values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getId());
			pstmt.setString(2, department.getName());
			pstmt.setString(3, department.getDescribe());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}finally{
			DBUtils.close(pstmt, null);
		}
	}

	@Override
	public PageInfo<Department> getAllDepartWithEmpCount(int currentPage,int pageSize)
			throws DataAccessException {
		Statement stmt = null;
		ResultSet rs = null;
		PageInfo<Department> pageInfo = new PageInfo<Department>();
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setSize(pageSize);
		try {
			Connection conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from department";
			rs = stmt.executeQuery(sql);
			rs.next();
			pageInfo.setTotle(rs.getInt(1));
			rs.close();
			sql = "select d.departid,departname,departdescrip,empCount"
					+ " from department d,(select departid, count(*) empCount from employee group by departid) e"
					+ " where e.departid(+) = d.departid ";
			rs = stmt.executeQuery(sql);
			List<Department> list = new ArrayList<>();
			while(rs.next()){
				Department d = new Department();
				d.setId(rs.getString("departid"));
				d.setName(rs.getString("departname"));
				d.setDescribe(rs.getString("departdescrip"));
				d.setEmpCount(rs.getInt("empCount"));
				System.out.println(d);
				list.add(d);
			}
			pageInfo.setPageInfos(list);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(stmt, rs);
		}
		return pageInfo;
	}

	@Override
	public List<Department> findAllDepart() throws DataAccessException {
		Statement pstmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "select * from department";
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			List<Department> list = new ArrayList<>();
			while(rs.next()){
				Department d = new Department();
				d.setId(rs.getString("departid"));
				d.setName(rs.getString("departname"));
				d.setDescribe(rs.getString("departdescrip"));
				System.out.println(d);
				list.add(d);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}finally{
			DBUtils.close(pstmt, rs);
		}
	}

	@Override
	public Department getDepartById(String id) throws DataAccessException {
		Statement pstmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "select * from department where departid = '"+id+"'";
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			List<Department> list = new ArrayList<>();
			while(rs.next()){
				Department d = new Department();
				d.setId(rs.getString("departid"));
				d.setName(rs.getString("departname"));
				d.setDescribe(rs.getString("departdescrip"));
				System.out.println(d);
				list.add(d);
			}
			if(list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}finally{
			DBUtils.close(pstmt, rs);
		}
	}

	@Override
	public int updateDepartment(Department department)
			throws DataAccessException {
		PreparedStatement pstmt = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "update department set departname = ? , departdescrip = ? where departid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getName());
			pstmt.setString(2, department.getDescribe());
			pstmt.setString(3, department.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}finally{
			DBUtils.close(pstmt,null);
		}
	}
}
