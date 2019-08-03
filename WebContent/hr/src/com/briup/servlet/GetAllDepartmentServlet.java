package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.briup.bean.Department;
import com.briup.service.IDepartmentService;
import com.briup.service.impl.DepartmentServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/getAllDepart.do")
public class GetAllDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDepartmentService departService = new DepartmentServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		List<Department> list = null;
		try {
			list = departService.getAllDepart();
			String str = JSONArray.toJSONString(list);
			PrintWriter pw = response.getWriter();
			pw.println(str);
			pw.close();
		} catch (ServiceException e) {
		}
	}

}
