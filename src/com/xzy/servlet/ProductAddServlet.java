package com.xzy.servlet;

import com.xzy.entity.Product;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        product.setProductName(map.get("productName")[0]);
        product.setProductCode(map.get("productCode")[0]);
        product.setProductCategoryId(Integer.parseInt(map.get("productCategoryId")[0]));
        product.setPrice(Double.parseDouble(map.get("price")[0]));
        product.setFounderId(Integer.parseInt(map.get("founderId")[0]));
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setFlag(Integer.parseInt(map.get("e")[0]));
        PRODUCTSERVICE.addProduct(product);
        response.sendRedirect("ProductToListServlet");
    }
}
