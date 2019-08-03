package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

@WebServlet("/getAttendOfEmp.do")
public class GetAttendOfEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAttendanceService attendService = new AttendanceServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String date = request.getParameter("date");
		if(date==null){
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
			date = sf.format(new Date());
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		try {
			List<Attendance> list = attendService.findEmpAttend(emp.getId(), date);
			String str = "";
			//"signDay":"10","status":"1"
			Calendar c = Calendar.getInstance();
			for(Attendance ac:list){
				c.setTime(ac.getAttendTime());
				str += "{\"signDay\":\""+c.get(Calendar.DATE)+
						"\",\"status\":\""+ac.getAttendState()+"\"},";
			}
			if(str.length()>0){
				str = "["+str.substring(0,str.length()-1)+"]";
			}
			pw.write(str);
		} catch (ServiceException e) {
			e.printStackTrace();
			pw.write("");
		}
		pw.flush();
		pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
