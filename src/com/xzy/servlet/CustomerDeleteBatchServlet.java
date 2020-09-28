package com.xzy.servlet;

import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CustomerDeleteBatchServlet")
public class CustomerDeleteBatchServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        CUSTOMERSERVICE.deleteCustomer(Integer.parseInt(customerId));
    }
}
