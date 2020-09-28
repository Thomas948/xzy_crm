package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/IndexData2Servlet")
public class IndexData2Servlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Double> list = new ArrayList<>();
        try {
            Date start = sdf.parse("2019-01-01 00:00:00");
            Date end = sdf.parse("2019-01-31 23:59:59");
            double contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-02-28 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-3-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-4-30 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-5-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-6-30 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-7-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-8-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-9-30 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-10-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-11-30 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

            end = sdf.parse("2019-12-31 23:59:59");
            contractMoney = CONTRACTSERVICE.getContractMoney(start, end);
            list.add(contractMoney);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.getWriter().write(JSON.toJSONString(list));
    }
}
