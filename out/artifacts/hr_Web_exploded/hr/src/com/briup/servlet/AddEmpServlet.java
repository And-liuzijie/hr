package com.briup.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.briup.bean.Employee;
import com.briup.service.IEmployeeService;
import com.briup.service.impl.EmployeeServiceImpl;
import com.briup.util.exception.ServiceException;
@WebServlet("/addEmp.do")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmployeeService empService;
	public void init() throws ServletException {
		empService = new EmployeeServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		/*if(ServletFileUpload.isMultipartContent(req)){
			ServletFileUpload sfu = new ServletFileUpload();
			sfu.setFileItemFactory(new DiskFileItemFactory());
			try {
				Map<String,List<FileItem>> map = sfu.parseParameterMap(req);
				for(String key:map.keySet()){
					System.out.println("key:"+key);
					List<FileItem> list = map.get(key);
					for(FileItem fi:list){
						if(fi.isFormField()){
							System.out.println("value:"+fi.getString());
						}else {
							System.out.println("fileName:"+fi.getName());
							String realPath = req.getServletContext().getRealPath("file/");
							System.out.println("realPath:"+realPath);
							File f = new File(realPath,fi.getName());
							fi.write(f);
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		String empid = req.getParameter("empid");
		String username = req.getParameter("username");
		String gender = req.getParameter("gender");
		String birthday = req.getParameter("birthday");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String department = req.getParameter("department");
		String role = req.getParameter("role");
		String salary = req.getParameter("salary");
		String info = req.getParameter("info");
		Employee emp = new Employee();
		emp.setName(username);
		emp.setGender(gender);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("birthday:"+birthday);
		try {
			emp.setBirthday(df.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emp.setEmail(email);
		emp.setTel(telephone);
		emp.setDeptID(department);
		emp.setImpRole(role);
		emp.setSalary(Double.parseDouble(salary));
		emp.setInfo(info);
		System.out.println("requestPath:"+req.getPathInfo());
		try {
			if(empid==null||"".equals(empid)){
				empService.addNewEmp(emp);
				resp.sendRedirect("searchEmpByCondition.do");
			}else{
				emp.setId(empid);
				empService.updateEmp(emp);
				req.setAttribute("emp", emp);
				req.setAttribute("msg", "修改成功！");
				req.getRequestDispatcher("emp/viewEmp.jsp").forward(req, resp);
			}
		} catch (ServiceException e) {
			req.setAttribute("msg", "操作失败！");
			if(empid==null||"".equals(empid)){
//				req.getRequestDispatcher("emp/addEmp.jsp").forward(req, resp);
				resp.sendRedirect("emp/addEmp.jsp");
			}else{
				req.getRequestDispatcher("emp/viewEmp.jsp").forward(req, resp);
			}
		}
	}
}
