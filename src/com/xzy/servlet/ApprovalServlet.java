package com.xzy.servlet;

import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        String status = request.getParameter("status");
        String employeeId = request.getParameter("employeeId");
        String contractId = request.getParameter("contractId");

        CONTRACTSERVICE.updateContractFlag(Integer.parseInt(flag), Integer.parseInt(employeeId), Integer.parseInt(contractId), Integer.parseInt(status));
        response.sendRedirect("ApprovalListServlet");
    }
}
