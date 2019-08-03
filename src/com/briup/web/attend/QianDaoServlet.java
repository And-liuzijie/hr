package com.briup.web.attend;

import com.briup.bean.Attendance;
import com.briup.bean.Employee;
import com.briup.mapper.AttendanceMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet( "/QianDao")
public class QianDaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Employee employee= (Employee) session.getAttribute("userInfo");

        Date nowDate=new Date();
        System.out.println(nowDate);

        Attendance attendance=new Attendance();

        attendance.setEmpId(employee.getId());
        attendance.setAttendTime(nowDate);

        attendance.setAttendState(BigDecimal.valueOf(1));

        AttendanceMapper attendanceMapper=BriupUtil.getMapper(AttendanceMapper.class);
        int rec=attendanceMapper.insert(attendance);

        if(rec>0){
            request.getRequestDispatcher("/attendace/qiandao.jsp").forward(request,response);
        }
    }
}
