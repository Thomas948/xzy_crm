package com.xzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("email", "");
        Cookie cookie2 = new Cookie("password", "");
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        request.getSession().removeAttribute("employee");
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }
}
