package com.xzy.servlet;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.ProductExcel;
import com.xzy.entity.Product;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ExcelProductDownLoadServlet")
public class ExcelProductDownLoadServlet extends HttpServlet {

    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("application/vnd.ms-excel");*/
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=product.xlsx");

        List<Product> products = PRODUCTSERVICE.getProductList();
        List<ProductExcel> pes = new ArrayList<>();

        for (Product p : products) {
            ProductExcel pel = new ProductExcel();
            pel.setProductName(p.getProductName());
            pel.setProductCode(p.getProductCode());
            pel.setProductCategory(p.getCategory().getCategoryName());
            pel.setPrice(p.getPrice());
            pel.setFounder(p.getFounder().getEmployeeName());
            pel.setCreateTime(p.getCreateTime());
            pel.setUpdateTime(p.getUpdateTime());
            pel.setFlag(p.getFlag() == 1 ? "上架" : "下架");
            pes.add(pel);
        }
        EasyExcel.write(response.getOutputStream(),ProductExcel.class).sheet("产品信息").doWrite(pes);
    }
}
