package com.xzy.servlet;

import com.xzy.entity.Contract;
import com.xzy.entity.Employee;
import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ApprovalListServlet")
public class ApprovalListServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        List<Contract> contractList = CONTRACTSERVICE.getContractListByEmployeeId(employee.getEmployeeId());
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
