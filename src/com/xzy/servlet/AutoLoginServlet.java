package com.xzy.servlet;

import com.xzy.entity.Employee;
import com.xzy.service.EmployeeService;
import com.xzy.service.impl.EmployeeServiceImpl;
import com.xzy.utils.ResponseMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ResponseMsg message = new ResponseMsg();
        Employee employee = EMPLOYEESERVICE.getEmployeeByEmail(email);
        if (employee != null && employee.getPassword().equals(password)) {
            message.setCode(1);
            request.getSession().setAttribute("employee", employee);
        }
        response.getWriter().write(message.toString());
    }
}
