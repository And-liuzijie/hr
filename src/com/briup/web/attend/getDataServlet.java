package com.briup.web.attend;

import com.alibaba.fastjson.JSON;
import com.briup.bean.Attendance;
import com.briup.bean.AttendanceExample;
import com.briup.bean.Employee;
import com.briup.bean.vo.QianDao;
import com.briup.mapper.AttendanceMapper;
import com.briup.util.BriupUtil;

import javax.print.AttributeException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet( "/getData")
public class getDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Employee emp= (Employee) session.getAttribute("userInfo");

        AttendanceMapper attendanceMapper=BriupUtil.getMapper(AttendanceMapper.class);
        AttendanceExample example=new AttendanceExample();
        AttendanceExample.Criteria where=example.createCriteria();
        where.andEmpIdEqualTo(emp.getId());

        List<Attendance> list=attendanceMapper.selectByExample(example);
        System.out.println(list);
        List<QianDao> qdList=new ArrayList<QianDao>();
        for (Attendance att:list) {
            int  signDay=att.getAttendTime().getDate();
            if (signDay==new Date().getDate()){
                qdList.add(new QianDao(""+signDay,""+1));

            }else{
                qdList.add(new QianDao(""+signDay,""+2));
            }
        }
//list转换成json
       String jsonString= JSON.toJSONString(qdList,true);

//        ServletOutputStream outputStream=response.getOutputStream();
//
//        outputStream.write(jsonString.getBytes());
//
//        outputStream.close();
        PrintWriter  out=response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
