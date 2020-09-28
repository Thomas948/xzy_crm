package com.xzy.servlet;

import com.xzy.entity.*;
import com.xzy.service.*;
import com.xzy.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CustomerUpdateJumpServlet")
public class CustomerUpdateJumpServlet extends HttpServlet {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();
    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();
    private final SourcesService SOURCESSERVICE = new SourcesServiceImpl();
    private final IndustryService INDUSTRYSERVICE = new IndustryServiceImpl();
    private final LevelsService LEVELSSERVICE = new LevelsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        Customer customer = CUSTOMERSERVICE.getCustomerByCustomerId(Integer.parseInt(customerId));
        List<Employee> employeeList = EMPLOYEESERVICE.getEmployeeList();
        List<Sources> sourcesList = SOURCESSERVICE.getSourcesList();
        List<Industry> industryList = INDUSTRYSERVICE.getIndustryList();
        List<Levels> levelsList = LEVELSSERVICE.getLevelsList();
        request.setAttribute("customer", customer);
        request.setAttribute("employees", employeeList);
        request.setAttribute("sources", sourcesList);
        request.setAttribute("industries", industryList);
        request.setAttribute("levels", levelsList);
        request.getRequestDispatcher("/customer_update.jsp").forward(request, response);
    }
}
