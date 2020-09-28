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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        product.setProductId(Integer.parseInt(map.get("productId")[0]));
        product.setProductName(map.get("productName")[0]);
        product.setProductCode(map.get("productCode")[0]);
        product.setProductCategoryId(Integer.parseInt(map.get("categoryId")[0]));
        product.setPrice(Double.parseDouble(map.get("price")[0]));
        product.setFounderId(Integer.parseInt(map.get("founderId")[0]));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        product.setUpdateTime(date);
        try {
            date = sdf.parse(map.get("createTime")[0]);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        product.setCreateTime(date);
        product.setFlag(Integer.parseInt(map.get("e")[0]));
        PRODUCTSERVICE.updateProduct(product);
        response.sendRedirect("ProductToListServlet");
    }
}
