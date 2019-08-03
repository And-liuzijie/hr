package com.briup.web.attend;

import com.briup.bean.Employee;
import com.briup.bean.Leave;
import com.briup.bean.LeaveExample;
import com.briup.mapper.LeaveMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ApplyHoliday")
public class ApplyHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depName= request.getParameter("departId");
        String startTime= request.getParameter("startTime");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date startDate=null;
        try {
            startDate=simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endTime= request.getParameter("endTime");

        Date endDate=null;

        try {
            endDate=simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String reason= request.getParameter("reason");
        HttpSession session=request.getSession();
        Employee employee= (Employee) session.getAttribute("userInfo");

        Leave leave=new Leave();
        leave.setStrattime(startDate);
        leave.setEndtime(endDate);
        if(employee.getId()!=null&&!"".equals(employee.getId().trim())){
            leave.setEmpid(employee.getId());

        }
        leave.setReason(reason);
        LeaveMapper leaveMapper=BriupUtil.getMapper(LeaveMapper.class);

        int rec =leaveMapper.insert(leave);
        String msg="职员"+employee.getName()+"你的请假申请已经提交，时间为"+startTime+"---"+endTime+"请耐心等待审批";
        if (rec>0){
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/attendace/applyHoliday.jsp").forward(request,response);
        }
    }
}
