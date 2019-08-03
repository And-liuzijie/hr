package com.briup.web.emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Employee;
import com.briup.bean.EmployeeExample;
import com.briup.bean.Extrawork;
import com.briup.bean.ExtraworkExample;
import com.briup.bean.EmployeeExample.Criteria;
import com.briup.mapper.EmployeeMapper;
import com.briup.mapper.ExtraworkMapper;
import com.briup.util.BriupUtil;

/**
 * Servlet implementation class EmpExtraWorkServlet
 */
@WebServlet("/EmpExtraWork")
public class EmpExtraWorkServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("empId");

		EmployeeMapper daoEmp = BriupUtil.getMapper(EmployeeMapper.class);
		EmployeeExample example2 = new EmployeeExample();
		Criteria where2=example2.createCriteria();
		
		where2.andNameLike(username);
		List<Employee> emplist = daoEmp.selectByExample(example2);
		ExtraworkMapper daoExt = BriupUtil.getMapper(ExtraworkMapper.class);
		
		 ExtraworkExample example=new ExtraworkExample();
		 ExtraworkExample.Criteria where = example.createCriteria();
		 
		 List<Extrawork>  extraworkList=new ArrayList<Extrawork>();
		 for (Employee emp:emplist ) {
	             String id=emp.getId();
	             where.andEmpidEqualTo(id);
	             List<Extrawork> extraworks= daoExt.selectByExample(example);
	             for (Extrawork ext:extraworks){
	                ext.setEmployee(emp);
	             }
	             extraworkList.addAll(extraworks);
	        }
		 request.setAttribute("extraworkList",extraworkList);

	        request.getRequestDispatcher("/emp/empExtraworkList.jsp").forward(request,response);
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
