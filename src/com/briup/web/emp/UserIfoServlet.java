package com.briup.web.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Employee;
@WebServlet("/userInfo")
public class UserIfoServlet extends HttpServlet{
protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
	// TODO Auto-generated method stub
	   HttpSession httpSession=req.getSession();
	   Employee myEmpoyee=(Employee) httpSession.getAttribute("userInfo");
	   req.setAttribute("myemp", myEmpoyee);
	   req.getRequestDispatcher("/personal/myPage.jsp").forward(req, resp);
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doGet(req, resp);
}
}
