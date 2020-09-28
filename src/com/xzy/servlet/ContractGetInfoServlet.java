package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.dto.ContractProductResult;
import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContractGetInfoServlet")
public class ContractGetInfoServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractId = request.getParameter("contractId");
        ContractProductResult result = CONTRACTSERVICE.getContractByContractId(Integer.parseInt(contractId));
        String s = JSON.toJSONString(result);
        response.getWriter().write(s);
    }
}
