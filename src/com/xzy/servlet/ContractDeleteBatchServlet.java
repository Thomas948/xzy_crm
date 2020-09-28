package com.xzy.servlet;

import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContractDeleteBatchServlet")
public class ContractDeleteBatchServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractId = request.getParameter("contractId");
        System.out.println(contractId);
        CONTRACTSERVICE.deleteContract(Integer.parseInt(contractId));
    }
}
