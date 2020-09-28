package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.dto.Page;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CustomerGetPageServlet")
public class CustomerGetPageServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        String flag = request.getParameter("flag");
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page page = CUSTOMERSERVICE.getCustomerPages(Integer.parseInt(pageNo), Integer.parseInt(pageSize), Integer.parseInt(flag),keyword);
        String s = JSON.toJSONString(page);
        response.getWriter().write(s);
    }
}
