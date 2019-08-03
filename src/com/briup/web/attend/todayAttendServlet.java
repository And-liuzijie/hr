package com.briup.web.attend;

import com.briup.bean.Attendance;
import com.briup.bean.AttendanceExample;
import com.briup.bean.Employee;
import com.briup.bean.EmployeeExample;
import com.briup.mapper.AttendanceMapper;
import com.briup.mapper.EmployeeMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/todayAttend")
public class todayAttendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String departName=request.getParameter("departId");


        Date now=new Date();

        AttendanceMapper attendanceMapper=BriupUtil.getMapper(AttendanceMapper.class);

        AttendanceExample example=new AttendanceExample();
        AttendanceExample.Criteria where=example.createCriteria();

        where.andAttendTimeEqualTo(now);

        EmployeeMapper employeeMapper=BriupUtil.getMapper(EmployeeMapper.class);
//        EmployeeExample employeeExample=new EmployeeExample();
//        EmployeeExample.Criteria empWhere=employeeExample.createCriteria();
        List<Attendance> attList=attendanceMapper.selectByExample(example);
        for (Attendance att:attList
             ) {
            String empid=att.getEmpId();
//            empWhere.andIdEqualTo(empid);
            Employee employee= employeeMapper.selectByPrimaryKey(empid);
            att.setEmployee(employee);
        }
        request.setAttribute("attList",attList);
        request.getRequestDispatcher("/attendace/todayAttend.jsp").forward(request,response);
    }
}
