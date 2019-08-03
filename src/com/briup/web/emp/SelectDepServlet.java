package com.briup.web.emp;

import com.briup.bean.Department;
import com.briup.bean.DepartmentExample;
import com.briup.mapper.DepartmentMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectDepServlet")
public class SelectDepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!");
       DepartmentMapper depMapper=BriupUtil.getMapper(DepartmentMapper.class);
//       /* DepartmentExample example=new DepartmentExample();
//        DepartmentExample.Criteria where=example.createCriteria();*/
        List<Department> depList=depMapper.selectByExample(null);
        request.setAttribute("depList",depList);
        request.getRequestDispatcher("/emp/addEmp.jsp").forward(request,response);

        for (int i = 0; i <depList.size() ; i++) {
            System.out.println(depList.get(i).getName());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
