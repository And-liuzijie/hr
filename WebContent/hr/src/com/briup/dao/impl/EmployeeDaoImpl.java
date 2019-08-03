package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.dao.DBUtils;
import com.briup.dao.IEmployeeDao;
import com.briup.util.exception.DataAccessException;
import com.briup.util.exception.ServiceException;

public class EmployeeDaoImpl implements IEmployeeDao {
	public void saveEmployee(Employee emp) throws DataAccessException {
		PreparedStatement stmt = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "insert into employee (impId,impName,impGender,impBirth,impEmail,"
					+ "departId,impRoll,impSalary,impTel,impBio,impState) values ("
					+emp.getDeptID()+"||empid_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,emp.getName());
			stmt.setString(2, emp.getGender());
			stmt.setDate(3, new Date(emp.getBirthday().getTime()));
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getDeptID());
			stmt.setString(6, emp.getImpRole());
			stmt.setDouble(7, emp.getSalary());
			stmt.setString(8, emp.getTel());
			stmt.setString(9, emp.getInfo());
			stmt.setInt(10, emp.getImplState());
			stmt.execute();
		} catch (Exception e) {
			throw new DataAccessException(e);
		} finally {
			DBUtils.close(stmt, null);
		}
	}

	@Override
	public List<Employee> getEmployeeByPage(int currentPage,int pageSize) throws DataAccessException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select e.*,d.departName from (select impId,impName,impGender,impBirth,impEmail,"
					+ "departId,impRoll,impSalary,impTel,impBio,impState,rownum rw from employee) e ,department d "
					+ " where e.departId = d.departId and (e.rw between "+((currentPage-1)*pageSize+1)+" and "+currentPage*pageSize+")";
			System.out.println("sql："+sql);
			rs = stmt.executeQuery(sql);
			List<Employee> list = new ArrayList<>(pageSize);
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getString("impId"));
				emp.setName(rs.getString("impName"));
				emp.setGender(rs.getString("impGender"));
				emp.setBirthday(rs.getDate("impBirth"));
				emp.setEmail(rs.getString("impEmail"));
				emp.setDeptID(rs.getString("departId"));
				emp.setImpRole(rs.getString("impRoll"));
				emp.setSalary(rs.getDouble("impSalary"));
				emp.setTel(rs.getString("impTel"));
				emp.setInfo(rs.getString("impBio"));
				emp.setImplState(rs.getInt("impState"));
				Department d = new Department();
				d.setId(rs.getString("departId"));
				d.setName(rs.getString("departName"));
				emp.setDepartment(d);
				list.add(emp);
				System.out.println(emp);
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		} finally{
			DBUtils.close(stmt, rs);
		}
	}
	@Override
	public int getEmpCount() throws DataAccessException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from employee";
			rs = stmt.executeQuery(sql);
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		} finally{
			DBUtils.close(stmt, rs);
		}
	}

	@Override
	public Employee getEmpById(String id) throws DataAccessException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("dao....."+id);
			Connection conn = DBUtils.getConnection();
			String sql = "select * from employee where impId = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			List<Employee> list = new ArrayList<>();
			while(rs.next()){
				System.out.println("是否进来。。。。");
				Employee emp = new Employee();
				emp.setId(rs.getString("impId"));
				emp.setName(rs.getString("impName"));
				emp.setPassword(rs.getString("password"));
				emp.setGender(rs.getString("impGender"));
				emp.setBirthday(rs.getDate("impBirth"));
				emp.setEmail(rs.getString("impEmail"));
				emp.setDeptID(rs.getString("departId"));
				emp.setImpRole(rs.getString("impRoll"));
				emp.setSalary(rs.getDouble("impSalary"));
				emp.setTel(rs.getString("impTel"));
				emp.setInfo(rs.getString("impBio"));
				emp.setImplState(rs.getInt("impState"));
				list.add(emp);
			}
			if(list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		} finally{
			DBUtils.close(stmt, rs);
		}
	}

	@Override
	public void updateEmployee(Employee emp) throws DataAccessException {
		PreparedStatement stmt = null;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "update employee set impname=?,impgender=?,impbirth=?,impemail=?,"
					+ "departid=?,improll=?,impsalary=?,imptel=?,impbio=? "
					+ "where impid = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,emp.getName());
			stmt.setString(2, emp.getGender());
			stmt.setDate(3, new Date(emp.getBirthday().getTime()));
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getDeptID());
			stmt.setString(6, emp.getImpRole());
			stmt.setDouble(7, emp.getSalary());
			stmt.setString(8, emp.getTel());
			stmt.setString(9, emp.getInfo());
			stmt.setString(10, emp.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new DataAccessException(e);
		} finally {
			DBUtils.close(stmt, null);
		}
	}

	@Override
	public PageInfo<Employee> findEmpsByCondition(String deptName,String username,
			String empId,double downSalary,double upSalary,int currentPage,int pageSize) throws DataAccessException {
		String sql = "select * from employee where 1 = 1 ";
		if(deptName!=null&&!"".equals(deptName)){
			sql+= " and departId in (select departid from department where departname like '%"+deptName+"%') ";
		}
		if(username!=null&&!"".equals(username)){
			sql+=" and impName like '%"+username+"%' ";
		}
		if(empId!=null&&!"".equals(empId)){
			sql+= " and impId like '%"+empId+"%' ";
		}
		if(downSalary!=0.0d){
			sql+=" and impsalary >= "+downSalary;
		}
		if(upSalary!=0.0d){
			sql+=" and impSalary <= "+upSalary;
		}
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			String countSql = "select count(*) from ("+sql+")";
			rs = stmt.executeQuery(countSql);
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			String resultSql = "select e.*,d.departName from (select a.*,rownum rw from ("+sql+") a where rownum<= "
								+currentPage*pageSize+") e ,department d "
								+ " where e.rw >= "+((currentPage-1)*pageSize+1) +" and e.departId=d.departId";
			rs = stmt.executeQuery(resultSql);
			List<Employee> list = new ArrayList<>();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getString("impId"));
				emp.setName(rs.getString("impName"));
				emp.setGender(rs.getString("impGender"));
				emp.setBirthday(rs.getDate("impBirth"));
				emp.setEmail(rs.getString("impEmail"));
				emp.setDeptID(rs.getString("departId"));
				emp.setImpRole(rs.getString("impRoll"));
				emp.setSalary(rs.getDouble("impSalary"));
				emp.setTel(rs.getString("impTel"));
				emp.setInfo(rs.getString("impBio"));
				emp.setImplState(rs.getInt("impState"));
				Department d = new Department();
				d.setId(rs.getString("departId"));
				d.setName(rs.getString("departName"));
				emp.setDepartment(d);
				System.out.println("查找到的每一个emp："+emp);
				list.add(emp);
			}
			PageInfo<Employee> page = new PageInfo<Employee>();
			page.setCurrentPage(currentPage);
			page.setTotle(count);
			page.setSize(pageSize);
			page.setPageInfos(list);
			return page;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataAccessException( e);
		} finally {
			DBUtils.close(stmt, rs);
		}
	}
}
