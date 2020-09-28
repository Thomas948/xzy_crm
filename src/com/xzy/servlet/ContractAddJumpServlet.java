package com.xzy.servlet;

import com.xzy.entity.Customer;
import com.xzy.entity.Employee;
import com.xzy.entity.Product;
import com.xzy.service.CustomerService;
import com.xzy.service.EmployeeService;
import com.xzy.service.ProductService;
import com.xzy.service.impl.CustomerServiceImpl;
import com.xzy.service.impl.EmployeeServiceImpl;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ContractAddJumpServlet")
public class ContractAddJumpServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();
    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();
    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = EMPLOYEESERVICE.getEmployeeList();
        List<Customer> customerList = CUSTOMERSERVICE.getCustomerList(1);
        List<Product> productList = PRODUCTSERVICE.getProductList();
        productList.removeIf(p -> p.getFlag() == 0);//未上架的商品不能展示
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("productList",productList);

        request.getRequestDispatcher("/contract_add.jsp").forward(request, response);
    }
}
