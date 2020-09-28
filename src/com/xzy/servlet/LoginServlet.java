package com.xzy.servlet;

import com.google.code.kaptcha.Constants;
import com.xzy.entity.Employee;
import com.xzy.service.EmployeeService;
import com.xzy.service.impl.EmployeeServiceImpl;
import com.xzy.utils.ResponseMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");
        String rm = request.getParameter("rm");
        String kpSession = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        ResponseMsg message = new ResponseMsg();
        if (captcha != null && !captcha.equals("") && kpSession != null && !kpSession.equals("")) {
            if (captcha.equals(kpSession)) {
                Employee employee = EMPLOYEESERVICE.getEmployeeByEmail(email);
                if (employee != null && employee.getPassword().equals(password)) {
                    if (rm != null && rm.equals("1")) {
                        Cookie cookie1 = new Cookie("email", email);
                        Cookie cookie2 = new Cookie("password", password);
                        cookie1.setMaxAge(24 * 60 * 60);
                        cookie2.setMaxAge(24 * 60 * 60);
                        response.addCookie(cookie1);
                        response.addCookie(cookie2);
                    } else {
                        Cookie cookie1 = new Cookie("email", "");
                        Cookie cookie2 = new Cookie("password", "");
                        cookie1.setMaxAge(0);
                        cookie2.setMaxAge(0);
                        response.addCookie(cookie1);
                        response.addCookie(cookie2);
                    }
                    request.getSession().setAttribute("employee", employee);
                    message.setCode(1);
                } else {
                    message.setCode(-1);
                    message.setMsg("用户名或密码错误");
                }
            } else {
                message.setCode(-1);
                message.setMsg("验证码错误");
            }
        } else {
            message.setCode(-1);
            message.setMsg("未能获取到验证码");
        }
        response.getWriter().write(message.toString());
    }
}
