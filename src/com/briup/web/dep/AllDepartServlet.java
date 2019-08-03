package com.briup.web.dep;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Department;
import com.briup.bean.DepartmentExample;
import com.briup.bean.DepartmentExample.Criteria;
import com.briup.mapper.DepartmentMapper;
import com.briup.util.BriupUtil;


@WebServlet("/AllDepart")
public class AllDepartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String depName = request.getParameter("username");
		String deptId = request.getParameter("deptId");
		
	
		DepartmentMapper daoDepart = BriupUtil.getMapper(DepartmentMapper.class);
		DepartmentExample example = new DepartmentExample();
		Criteria where = example.createCriteria();
		if(depName!=null && !"".equals(depName.trim())) {
			depName = "%" + depName + "%";
			where.andDescribeEqualTo(depName);
		}
		if(deptId!=null && !"".equals(deptId.trim())) {
			where.andIdEqualTo(deptId);
		}
		
		
		List<Department> departList = daoDepart.selectByExample(example);
		/*for(int i=0;i<departList.size();i++) {
		String	name=departList.get(i).getName();
		System.out.println(name);
		}*/
		
	
		
		request.setAttribute("allDepartList", departList);
		request.getRequestDispatcher("/depart/departList.jsp").forward(request, response);
		System.out.println("-----------");
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
