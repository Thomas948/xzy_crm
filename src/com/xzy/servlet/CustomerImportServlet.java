package com.xzy.servlet;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xzy.entity.Customer;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CustomerImportServlet")
public class CustomerImportServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "E:\\Thomas's DownLoad\\customer.xlsx";
        Class<Customer> head = Customer.class;

        EasyExcel.read(fileName, head, new AnalysisEventListener<Customer>() {

            @Override
            public void invoke(Customer customer, AnalysisContext analysisContext) {
                CUSTOMERSERVICE.addCustomer(customer);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("数据解析完成");
            }
        }).sheet().doRead();
        response.sendRedirect("CustomerToListServlet");
    }
}
