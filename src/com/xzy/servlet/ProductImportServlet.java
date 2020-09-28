package com.xzy.servlet;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xzy.entity.Product;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductImportServlet")
public class ProductImportServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "E:\\Thomas's DownLoad\\product.xlsx";
        Class<Product> head = Product.class;

        EasyExcel.read(fileName, head, new AnalysisEventListener<Product>() {

            @Override
            public void invoke(Product product, AnalysisContext analysisContext) {
                PRODUCTSERVICE.addProduct(product);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("数据解析完成");
            }
        }).sheet().doRead();
        response.sendRedirect("ProductToListServlet");
    }
}
