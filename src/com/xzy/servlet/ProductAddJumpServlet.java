package com.xzy.servlet;


import com.xzy.entity.Category;
import com.xzy.entity.Employee;
import com.xzy.service.CategoryService;
import com.xzy.service.EmployeeService;
import com.xzy.service.impl.CategoryServiceImpl;
import com.xzy.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductAddJumpServlet")
public class ProductAddJumpServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();
    private final CategoryService CATEGORYSERVICE = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = EMPLOYEESERVICE.getEmployeeList();
        List<Category> categories = CATEGORYSERVICE.getCategories();
        request.setAttribute("employees", employeeList);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/product_add.jsp").forward(request, response);
    }
}
