package com.xzy.servlet;

import com.xzy.entity.Customer;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/CustomerAddServlet")
public class CustomerAddServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Customer customer = new Customer();
        customer.setCustomerName(map.get("customerName")[0]);
        customer.setPhone(map.get("phone")[0]);
        customer.setStatus(Integer.parseInt(map.get("e")[0]));
        customer.setPersonLiableId(Integer.parseInt(map.get("personLiableId")[0]));
        customer.setFounderId(Integer.parseInt(map.get("founderId")[0]));
        customer.setSourceId(Integer.parseInt(map.get("sourceId")[0]));
        customer.setIndustryId(Integer.parseInt(map.get("industryId")[0]));
        customer.setLevelId(Integer.parseInt(map.get("levelId")[0]));
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(map.get("nextContactTime")[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customer.setNextContactTime(date);
        customer.setFlag(1);
        CUSTOMERSERVICE.addCustomer(customer);
        response.sendRedirect("CustomerToListServlet");
    }
}
