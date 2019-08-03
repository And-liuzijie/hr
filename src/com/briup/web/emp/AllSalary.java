package com.briup.web.emp;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Salary;
import com.briup.mapper.EmployeeMapper;
import com.briup.mapper.SalaryMapper;
import com.briup.util.BriupUtil;


@WebServlet("/AllSal")
public class AllSalary extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String id = request.getParameter("id");
		String empid = request.getParameter("empid");
		String year = request.getParameter("year");
		String mon = request.getParameter("mon");
		String basicsalary = request.getParameter("basicsalary");
		String etrsalary = request.getParameter("etrsalary");
		String holidaysalary = request.getParameter("holidaysalary");
		String outsalary = request.getParameter("outsalary");
		
		int i = Integer.parseInt(id);
		int b = Integer.parseInt(basicsalary);
		int e = Integer.parseInt(etrsalary);
		int h = Integer.parseInt(holidaysalary);
		int o = Integer.parseInt(outsalary);*/
		
		
		SalaryMapper daoSal = BriupUtil.getMapper(SalaryMapper.class);
		List<Salary> allSalary = daoSal.selectByExample(null);
		for (Salary salary : allSalary) {
			Integer totalSalary=salary.getBasicsalary()+salary.getEtrasalary()+salary.getHolidaysalary()-salary.getOutsalary();
		     salary.setTotalSalary(totalSalary);
		}
		request.setAttribute("allSalary", allSalary);
		request.getRequestDispatcher("/salary.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
