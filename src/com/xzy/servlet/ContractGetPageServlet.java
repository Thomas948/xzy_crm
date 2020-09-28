package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xzy.dto.Page;
import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContractGetPageServlet")
public class ContractGetPageServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

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
        Page page = CONTRACTSERVICE.getContractPages(Integer.parseInt(pageNo), Integer.parseInt(pageSize), keyword);

        String s = JSON.toJSONString(page, SerializerFeature.WriteDateUseDateFormat);
        response.getWriter().write(s);

    }
}