package com.xzy.servlet;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.CustomerExcel;
import com.xzy.dto.ThreadExcel;
import com.xzy.entity.Customer;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ExcelCustomerDownLoadServlet")
public class ExcelCustomerDownLoadServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("application/vnd.ms-excel");*/
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=customer.xlsx");

        List<Customer> customerList = CUSTOMERSERVICE.getCustomerList(1);
        List<CustomerExcel> ces = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerExcel cel = new CustomerExcel();
            cel.setCustomerName(customer.getCustomerName());
            cel.setPhone(customer.getPhone());
            cel.setPersonLiable(customer.getPersonLiable().getEmployeeName());
            cel.setFounder(customer.getFounder().getEmployeeName());
            cel.setSource(customer.getSource().getSourceName());
            cel.setIndustry(customer.getIndustry().getIndustryName());
            cel.setLevel(customer.getLevel().getLevelName());
            cel.setCreateTime(customer.getCreateTime());
            cel.setUpdateTime(customer.getUpdateTime());
            cel.setNextContactTime(customer.getNextContactTime());
            cel.setStatus(customer.getStatus()==1?"已签约":"未签约");
            ces.add(cel);
        }
        EasyExcel.write(response.getOutputStream(), CustomerExcel.class).sheet("线索信息").doWrite(ces);
    }
}
