package com.briup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "lanli";
	private static String pwd = "lanli";
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection conn = threadLocal.get();
		if(conn==null){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pwd);
			threadLocal.set(conn);
		}
		return conn;
	}
	
	public static void closeConn() throws SQLException{
		Connection conn = threadLocal.get();
		threadLocal.set(null);
		if(conn!=null){
			conn.close();
		}
	}
	public static void close(Statement stmt,ResultSet rs){
		if(stmt!=null){
			try {	stmt.close();	} catch (SQLException e) {		}
		}
		if(rs!=null){
			try {	rs.close();	} catch (SQLException e) {		}
		}
	}
}
