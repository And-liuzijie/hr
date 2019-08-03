package com.briup.web.dep;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Department;
import com.briup.bean.Employee;
import com.briup.mapper.DepartmentMapper;
import com.briup.util.BriupUtil;

import sun.awt.RepaintArea;

@WebServlet("/addDep")
public class addDepartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Employee employee1= (Employee) session.getAttribute("userInfo");
		System.out.println(employee1.getDepName());
		if(employee1.getDepName().equals("公司管理董事层")) {
	
		String id = request.getParameter("departId");
		
		String name = request.getParameter("departname");
		
		String describe = request.getParameter("info");
		
		Department dep = new Department();
		
		dep.setId(id);
		dep.setDescribe(describe);
		dep.setName(name);
		
		DepartmentMapper daoDep = BriupUtil.getMapper(DepartmentMapper.class);
		
		if(id!=null && !"".equals(id.trim()) && name!=null && !"".equals(name.trim())) {
			
		}else {
			request.setAttribute("msg", "部门名称和编号不能为空");
			request.getRequestDispatcher("/depart/addDepart.jsp").forward(request, response);
		}
		
		daoDep.insert(dep);
		List<Department> depList = daoDep.selectByExample(null);
		request.setAttribute("allDepartList", depList);
		request.getRequestDispatcher("/depart/departList.jsp").forward(request, response);


		}else {
			request.setAttribute("msg","你不是公司管理层人员，没有权限添加部门");
			request.getRequestDispatcher("/depart/addDepart.jsp").forward(request, response);

		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
