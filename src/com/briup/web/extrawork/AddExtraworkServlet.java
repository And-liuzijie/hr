package com.briup.web.extrawork;

import com.briup.bean.Extrawork;
import com.briup.mapper.ExtraworkMapper;
import com.briup.util.BriupUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddExtrawork")
public class AddExtraworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  empId=request.getParameter("empId");
        String  startTime=request.getParameter("startTime");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date startDate=null;
        try {
            startDate=simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String  endTime=request.getParameter("endTime");
        Date endDate=null;

        try {
            endDate=simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String  reason=request.getParameter("reason");

        Extrawork extrawork=new Extrawork();
        extrawork.setEmpid(empId);
        extrawork.setStarttime(startDate);
        extrawork.setEdntime(endDate);
        extrawork.setReason(reason);
        ExtraworkMapper extraWorkMapper=BriupUtil.getMapper(ExtraworkMapper.class);

        int rec=extraWorkMapper.insert(extrawork);
        if (rec>0){
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("/extrawork/addExtrawork.jsp").forward(request,response);
        }
    }
}
