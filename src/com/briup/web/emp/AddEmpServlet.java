package com.briup.web.emp;

import com.briup.bean.Employee;
import com.briup.bean.EmployeeExample;
import com.briup.mapper.EmployeeMapper;
import com.briup.util.BriupUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Employee employee1= (Employee) session.getAttribute("userInfo");
        if(employee1.getDepName().equals("公司管理董事层")) {
            Employee employee = new Employee();
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (birthday != null && !"".equals(birthday.trim())) {
                Date birth = null;
                try {
                    birth = dateFormat.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                employee.setBirthday(birth);

            }

            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String department = request.getParameter("department");
            String role = request.getParameter("role");
            String salary = request.getParameter("salary");
            if (salary != null && !"".equals(salary.trim())) {
                int Intsalary = Integer.parseInt(salary);
                employee.setSalary(BigDecimal.valueOf(Intsalary));
            }
            String info = request.getParameter("info");

            employee.setName(name);
            employee.setPassword(password);
            employee.setGender(gender);
            employee.setEmail(email);
            employee.setTel(telephone);
            if (department != null && !"".equals(department)) {
                String[] split = department.split("[-]");
                String depId = split[0];
                String depName = split[1];
                employee.setDepId(depId);
                employee.setDepName(depName);
            }

            employee.setImpRole(role);
            employee.setInfo(info);

            EmployeeMapper empMapper = BriupUtil.getMapper(EmployeeMapper.class);
            if (name != null && !"".equals(name.trim())
                    && password != null && !"".equals(password.trim())
                    ) {
                empMapper.insert(employee);
                List<Employee> empList = empMapper.selectByExample(null);
                request.setAttribute("allEmList", empList);
                request.setAttribute("msg", "注册成功");
                request.getRequestDispatcher("/emp/empList.jsp").forward(request, response);


            } else {

                request.setAttribute("msg", "用户名密码不能为空");
                request.getRequestDispatcher("/emp/addEmp.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("msg","你不是公司管理层人员，没有权限注册职工");
            request.getRequestDispatcher("/emp/addEmp.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
