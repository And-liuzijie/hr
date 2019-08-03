package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Department;
import com.briup.service.IDepartmentService;
import com.briup.service.impl.DepartmentServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/addDepart.do")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDepartmentService departService = new DepartmentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String departId = req.getParameter("departId");
		String departname = req.getParameter("departname");
		String info = req.getParameter("info");
		Department depart = new Department();
		depart.setId(departId);
		depart.setName(departname);
		depart.setDescribe(info);
		try {
			departService.saveOrUpdateDepartement(depart);
			resp.sendRedirect("departList.do");
		} catch (ServiceException e) {
			e.printStackTrace();
			req.getRequestDispatcher("depart/addDepart.jsp").forward(req, resp);
		}
	}
}
