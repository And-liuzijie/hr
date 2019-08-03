package com.briup.web.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Employee;
import com.briup.mapper.EmployeeMapper;
import com.briup.util.BriupUtil;


@WebServlet("/myEmp")
public class MyEmployeeServlet extends  HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String	id=req.getParameter("id");
	    System.out.println("id:"+id);
	    
	   EmployeeMapper empMapper=BriupUtil.getMapper(EmployeeMapper.class);
	   
	   Employee myEmpoyee=empMapper.selectByPrimaryKey(id);
	   
	   req.setAttribute("myemp", myEmpoyee);
	   req.getRequestDispatcher("/personal/myPage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(req, resp);	
	}
}
