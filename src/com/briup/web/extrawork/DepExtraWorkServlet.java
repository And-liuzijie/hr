package com.briup.web.extrawork;

import com.briup.bean.Employee;
import com.briup.bean.EmployeeExample;
import com.briup.bean.Extrawork;
import com.briup.bean.ExtraworkExample;
import com.briup.mapper.EmployeeMapper;
import com.briup.mapper.ExtraworkMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/DepExtraWork")
public class DepExtraWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depName=request.getParameter("deptId");
        EmployeeMapper employeeMapper=BriupUtil.getMapper(EmployeeMapper.class);
        EmployeeExample example= new EmployeeExample();
        EmployeeExample.Criteria where=example.createCriteria();
        where.andDepNameLike(depName);
        List<Employee> employeeList=employeeMapper.selectByExample(example);

        ExtraworkMapper extraworkMapper=BriupUtil.getMapper(ExtraworkMapper.class);
        ExtraworkExample example1=new ExtraworkExample();
        ExtraworkExample.Criteria where1=example1.createCriteria();
        List<Extrawork>  extraworkList=new ArrayList<Extrawork>();
        for (Employee emp:employeeList
             ) {
             String id=emp.getId();
             where1.andEmpidEqualTo(id);
             List<Extrawork> extraworks= extraworkMapper.selectByExample(example1);
             for (Extrawork ext:extraworks){
                ext.setEmployee(emp);
             }
             extraworkList.addAll(extraworks);
        }
        request.setAttribute("extraworkList",extraworkList);

        request.getRequestDispatcher("/extrawork/depExtraworkList.jsp").forward(request,response);
    }
}
