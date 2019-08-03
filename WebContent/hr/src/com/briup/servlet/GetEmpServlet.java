package com.briup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Employee;
import com.briup.service.IEmployeeService;
import com.briup.service.impl.EmployeeServiceImpl;
import com.briup.util.exception.ServiceException;
@WebServlet("/GetEmpServlet.do")
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmployeeService empService = new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cPage = request.getParameter("currentPage");
		String size = request.getParameter("pageSize");
		int currentPage = 1;
		int pageSize = 10;
		if(cPage!=null&&!"".equals(cPage)){
			currentPage = Integer.parseInt(cPage);
		}
		if(size!=null&&!"".equals(size)){
			pageSize = Integer.parseInt(size);
		}
		try {
			List<Employee> list = empService.getEmpsByPage(currentPage, pageSize);
			request.setAttribute("emps", list);
			request.setAttribute("pageCount", empService.getPageCount(pageSize));
			request.getRequestDispatcher("emp/empList.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher("emp/empList.jsp").forward(request, response);
		}
	}
}
