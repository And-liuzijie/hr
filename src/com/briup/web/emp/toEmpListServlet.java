package com.briup.web.emp;

import com.briup.bean.Employee;
import com.briup.bean.vo.EmployeeVo;
import com.briup.mapper.EmployeeMapper;
import com.briup.util.BriupUtil;
import com.briup.util.SimplePage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/toEmpList")
public class toEmpListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String pageNo=request.getParameter("pageNo");
           //当前用户点击的页面
        int pageNow=pageNo==null?1:Integer.parseInt(pageNo);
        int count=2;//  一页两条数据
        int min =(pageNow-1)*count+1;
        int max=(pageNow*count);
        EmployeeMapper employeeMapper=BriupUtil.getMapper(EmployeeMapper.class);
        EmployeeVo vo=new EmployeeVo();
        vo.setMin(min);
        vo.setMax(max);
        List<Employee>  employeeList=  employeeMapper.selectByExamplePage(vo);
        //处理页面需要的数据
        SimplePage<Employee> simplePage =new SimplePage<Employee>();
        simplePage.setPage(count);
        //
        simplePage.setPageNo(pageNow);
        //设置emp总的数据量
        simplePage.setPageDataNum(employeeMapper.countByExample(null));

        simplePage.setList(employeeList);
        request.setAttribute("simplePage",simplePage);

        request.getRequestDispatcher("/emp/empList.jsp").forward(request,response);

//        String pageNo = request.getParameter("pageNo");

//        int pageNoo = pageNo==null?1:Integer.parseInt(pageNo);
//
//        int page =2;
//        int min =(pageNoo-1)*page+1;
//        int max =(pageNoo*page);
//        //操作dao层对象
//        EmployeeMapper dao = BriupUtil.getMapper(EmployeeMapper.class);
//
//        EmployeeVo vo =new EmployeeVo();
//        vo.setMin(min);
//        vo.setMax(max);
//        //应该下本页显示的数据
//        List<Employee> list = dao.selectByExamplePage(vo);
//        System.out.println(list);
//        //处理页面需要的数据
//        SimplePage<Employee> simplePage =new SimplePage<Employee>();
//        //设置每页显示数据量
//        simplePage.setPage(page);
//
//        simplePage.setPageNo(pageNoo);
//        //
//        simplePage.setPageDataNum(dao.countByExample(null));
//        simplePage.setList(list);
//
//        request.setAttribute("simplePage", simplePage);
//        request.getRequestDispatcher("/emp/empList.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
