package com.xzy.servlet;

import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] productIds = request.getParameterValues("productId");
        for (String productId : productIds) {
            productService.deleteProduct(Integer.parseInt(productId));
        }
        response.sendRedirect("ProductToListServlet");
    }
}
