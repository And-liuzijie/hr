package com.briup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Department;
import com.briup.bean.Employee;
import com.briup.bean.PageInfo;
import com.briup.service.IDepartmentService;
import com.briup.service.impl.DepartmentServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/departList.do")
public class DepartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDepartmentService departService = new DepartmentServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			PageInfo<Department> page = 
					departService.getDepartWithCount(currentPage, pageSize);
			request.setAttribute("pageInfo", page);
			request.getRequestDispatcher("depart/departList.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("depart/departList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
