package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.dto.Page;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductGetPageServlet")
public class ProductGetPageServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page page = PRODUCTSERVICE.getProductPages(Integer.parseInt(pageNo), Integer.parseInt(pageSize), keyword);
        String s = JSON.toJSONString(page);
        response.getWriter().write(s);
    }
}
