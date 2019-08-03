package com.briup.web.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.AttendanceExample.Criteria;
import com.briup.bean.Employee;
import com.briup.bean.EmployeeExample;
import com.briup.mapper.EmployeeMapper;
import com.briup.util.BriupUtil;

@WebServlet("/allEmp")
public class AllEmployeeServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String deptName=req.getParameter("deptName");
			String username=req.getParameter("username");
			String empId=req.getParameter("empId");
			String downSalary=req.getParameter("downSalary");
			String upSalary=req.getParameter("upSalary");
			//从数据库中查询全部员工信息
			EmployeeMapper emMapper=BriupUtil.getMapper(EmployeeMapper.class);

			EmployeeExample example=new EmployeeExample();
			com.briup.bean.EmployeeExample.Criteria where=example.createCriteria();
			if (deptName!=null&&""!=deptName.trim()){
				where.andDepNameLike(deptName);
			}else
			if(username!=null&&""!=username.trim()){
				where.andNameLike(username);
			}else
			if (empId!=null&&""!=empId.trim()){
				where.andIdEqualTo(empId);
			}else
			if(downSalary!=null&&""!=downSalary.trim()){
				int dSalary=Integer.parseInt(downSalary);
				where.andSalaryGreaterThanOrEqualTo(dSalary);
			}else
			if(upSalary!=null&&""!=upSalary.trim()){
				int uSalary=Integer.parseInt(upSalary);
				where.andSalaryLessThanOrEqualTo(upSalary);
			}
			List<Employee> empList=emMapper.selectByExample(example);
			req.setAttribute("allEmList", empList);
			req.getRequestDispatcher("/emp/empList.jsp").forward(req, resp);
			for (int i = 0; i <empList.size(); i++) {

				Employee employee=empList.get(i);
				System.err.println("id"+employee.getId());
				System.out.println("name"+employee.getName());
				System.out.println("pwd"+employee.getPassword());
				System.out.println("email"+employee.getEmail());
			}


	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
