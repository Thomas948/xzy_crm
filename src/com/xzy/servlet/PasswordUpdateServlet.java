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

@WebServlet("/PasswordUpdateServlet")
public class PasswordUpdateServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        String confirmpwd = request.getParameter("confirmpwd");
        ResponseMsg rmsg = new ResponseMsg();
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (employee != null) {
            if (employee.getPassword().equals(oldpwd)) {
                if (newpwd.equals(confirmpwd)) {
                    EMPLOYEESERVICE.updatePassword(newpwd, employee.getEmployeeId());
                    rmsg.setCode(1);
                    rmsg.setMsg("修改成功");
                    employee.setPassword(newpwd);
                    request.getSession().setAttribute("employee",employee);
                } else {
                    rmsg.setCode(-1);
                    rmsg.setMsg("两次输入新密码不一致");
                }
            } else {
                rmsg.setCode(-1);
                rmsg.setMsg("原密码输入错误");
            }
        } else {
            rmsg.setCode(-1);
            rmsg.setMsg("还未登录,请先登录");
        }
        response.getWriter().write(rmsg.toString());

    }
}
