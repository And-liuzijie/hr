package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Employee;
import com.briup.service.IEmployeeService;
import com.briup.service.impl.EmployeeServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IEmployeeService empService = new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		System.out.println("username:"+userId);
		System.out.println("password:"+password);
		try {
			Employee emp = empService.login(userId, password);
			HttpSession session = req.getSession();
			session.setAttribute("emp",emp);
			if("1".equals(emp.getDeptID())){
				resp.sendRedirect("main.jsp");
			}else{
				resp.sendRedirect("staff/main.jsp");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
}
