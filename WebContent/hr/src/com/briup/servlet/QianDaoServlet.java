package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Attendance;
import com.briup.bean.Employee;
import com.briup.service.IAttendanceService;
import com.briup.service.impl.AttendanceServiceImpl;
import com.briup.util.exception.ServiceException;

@WebServlet("/qianDaoServlet.do")
public class QianDaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAttendanceService attendService = new AttendanceServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Attendance ac = new Attendance();
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		ac.setEmp(emp);
		ac.setAttendTime(new Date());
		ac.setAttendState(1);
		PrintWriter pw = response.getWriter();
		try {
			attendService.qianDao(ac);
			//response.sendRedirect("attendace/qiandao.jsp");
			pw.println("签到成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
			pw.print("签到失败！");
		}
		pw.flush();
		pw.close();
	}

}
