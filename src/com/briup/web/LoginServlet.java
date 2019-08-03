package com.briup.web;

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
@WebServlet("/login")   //  /表示绝对路径

public class LoginServlet extends HttpServlet {
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
          String name=req.getParameter("username");
          String pwd=req.getParameter("password");
          System.out.println(name+"-"+pwd);
          //利用工具类获取mapper
          EmployeeMapper daoEmp=BriupUtil.getMapper(EmployeeMapper.class);
          //
          EmployeeExample example=new EmployeeExample(); 
          com.briup.bean.EmployeeExample.Criteria where= example.createCriteria();
          
          //相当于where name =  “？？”
          where.andNameEqualTo(name);
          
    	  List<Employee> empList=daoEmp.selectByExample(example);
          
    	  if(empList!=null&&empList.size()>0) {
    		  Employee employee=empList.get(0);
    		  if(employee.getPassword().equals(pwd)) {
    		  	 HttpSession httpSession=req.getSession();
    		  	 httpSession.setAttribute("userInfo",employee );
    			  req.getRequestDispatcher("main.jsp").forward(req, resp);
    			 
    			  System.out.println("跳到了main");
    		  }else {
    			  req.setAttribute("msg", "密码错误");
        		  req.getRequestDispatcher("/login.jsp").forward(req, resp);//请求重定向
    		  }
    		  
    	  }else {	
    		  req.setAttribute("msg", "您还没有注册");
    		  req.getRequestDispatcher("/login.jsp").forward(req, resp);//请求重定向
    	  }
         
    } 
     
     
     

     //信息在请求体
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
         System.out.println("post!!!");
    	 doGet(req, resp);
    }
}
