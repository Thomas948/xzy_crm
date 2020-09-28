package com.xzy.servlet;

import com.alibaba.excel.EasyExcel;
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

@WebServlet("/ExcelThreadDownLoadServlet")
public class ExcelThreadDownLoadServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("application/vnd.ms-excel");*/
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=thread.xlsx");

        List<Customer> threadList = CUSTOMERSERVICE.getCustomerList(0);
        List<ThreadExcel> tes = new ArrayList<>();

        for (Customer thread : threadList) {
            ThreadExcel tel = new ThreadExcel();
            tel.setThreadName(thread.getCustomerName());
            tel.setPhone(thread.getPhone());
            tel.setPersonLiable(thread.getPersonLiable().getEmployeeName());
            tel.setFounder(thread.getFounder().getEmployeeName());
            tel.setSource(thread.getSource().getSourceName());
            tel.setIndustry(thread.getIndustry().getIndustryName());
            tel.setLevel(thread.getLevel().getLevelName());
            tel.setCreateTime(thread.getCreateTime());
            tel.setUpdateTime(thread.getUpdateTime());
            tel.setNextContactTime(thread.getNextContactTime());
            tes.add(tel);
        }
        EasyExcel.write(response.getOutputStream(), ThreadExcel.class).sheet("线索信息").doWrite(tes);
    }
}
