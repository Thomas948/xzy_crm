package com.xzy.servlet;

import com.xzy.entity.Category;
import com.xzy.entity.Employee;
import com.xzy.entity.Product;
import com.xzy.service.CategoryService;
import com.xzy.service.EmployeeService;
import com.xzy.service.ProductService;
import com.xzy.service.impl.CategoryServiceImpl;
import com.xzy.service.impl.EmployeeServiceImpl;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductUpdateJumpServlet")
public class ProductUpdateJumpServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();
    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();
    private final CategoryService CATEGORYSERVICE = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        List<Category> categories = CATEGORYSERVICE.getCategories();
        request.setAttribute("categories", categories);
        List<Employee> employees = EMPLOYEESERVICE.getEmployeeList();
        request.setAttribute("employees", employees);
        Product product = PRODUCTSERVICE.getProductByProductId(Integer.parseInt(productId));
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product_update.jsp").forward(request, response);
    }
}
