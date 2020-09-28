package com.xzy.servlet;

import com.xzy.entity.Employee;
import com.xzy.service.EmployeeService;
import com.xzy.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        String icon = request.getParameter("icon");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String remark = request.getParameter("remark");
        Employee employee = EMPLOYEESERVICE.getEmployeeByEmployeeId(Integer.parseInt(employeeId));
        List<Employee> employeeList = EMPLOYEESERVICE.getEmployeeList();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId()!=Integer.parseInt(employeeId)&&emp.getEmail().equals(email)) {
                request.setAttribute("msg", email+":此邮箱不可用");
            }
        }
        employee.setEmail(email);
        employee.setNickName(nickname);
        employee.setIcon(icon);
        employee.setRemark(remark);
        EMPLOYEESERVICE.updateEmployee(employee);
        request.getSession().setAttribute("employee",employee);
        request.getRequestDispatcher("/user_info.jsp").forward(request,response);
    }
}
