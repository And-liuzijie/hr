package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.service.IEmployeeService;
import com.briup.service.impl.EmployeeServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/searchEmpByCondition.do")
public class SearchEmpServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IEmployeeService empService = new EmployeeServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String deptName = req.getParameter("deptName");
		String username = req.getParameter("username");
		String empId = req.getParameter("empId");
		String downSalary = req.getParameter("downSalary");
		String upSalary = req.getParameter("upSalary");
		String cPage = req.getParameter("currentPage");
		String size = req.getParameter("pageSize");
		String queryStr = req.getQueryString();
		if(queryStr!=null&&!"".equals(queryStr))
			queryStr = queryStr.replaceAll("&currentPage=\\d&pageSize=\\d", "");
		System.out.println("queryStr:"+queryStr);
		double down = 0.0D;
		if(downSalary!=null&&!"".equals(downSalary)){
			down = Double.parseDouble(downSalary);
		}
		double up = 0.0D;
		if(upSalary!=null&&!"".equals(upSalary)){
			up = Double.parseDouble(upSalary);
		}
		int currentPage = 1;
		int pageSize = 7;
		if(cPage!=null&&!"".equals(cPage)){
			currentPage = Integer.parseInt(cPage);
		}
		if(size!=null&&!"".equals(size)){
			pageSize = Integer.parseInt(size);
		}
		try {
			PageInfo<Employee> page = 
					empService.getEmployees(deptName, username, empId, down, up,currentPage,pageSize);
			req.setAttribute("pageInfo", page);
			req.setAttribute("condition", queryStr);
			req.getRequestDispatcher("emp/empList2.jsp").forward(req, resp);
		} catch (ServiceException e) {
			req.getRequestDispatcher("emp/empList2.jsp").forward(req, resp);
		}
	}
}
