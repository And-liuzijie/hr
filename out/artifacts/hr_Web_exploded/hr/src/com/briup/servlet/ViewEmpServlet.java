package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Employee;
import com.briup.service.IEmployeeService;
import com.briup.service.impl.EmployeeServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/viewEmp.do")
public class ViewEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmployeeService empService = new EmployeeServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("员工编号："+id);
		try {
			Employee emp = empService.getEmpsById(id);
			System.out.println("emp:"+emp);
			req.setAttribute("emp", emp);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("emp/viewEmp.jsp").forward(req, resp);
	}
}
