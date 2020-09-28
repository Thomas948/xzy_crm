package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.dto.BarChartData;
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

@WebServlet("/IndexDataServlet")
public class IndexDataServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BarChartData> list = new ArrayList<>();
        try {
            Date start = sdf.parse("2019-01-01 00:00:00");
            Date end = sdf.parse("2019-01-31 23:59:59");
            double contractMoney1 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData1 = new BarChartData(contractMoney1, "一月");

            start =sdf.parse("2019-02-01 00:00:00");
            end = sdf.parse("2019-02-28 23:59:59");
            double contractMoney2 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData2 = new BarChartData(contractMoney2, "二月");

            start = sdf.parse("2019-03-01 00:00:00");
            end = sdf.parse("2019-3-31 23:59:59");
            double contractMoney3 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData3 = new BarChartData(contractMoney3, "三月");

            start = sdf.parse("2019-04-01 00:00:00");
            end = sdf.parse("2019-4-30 23:59:59");
            double contractMoney4 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData4 = new BarChartData(contractMoney4, "四月");

            start = sdf.parse("2019-05-01 00:00:00");
            end = sdf.parse("2019-5-31 23:59:59");
            double contractMoney5 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData5 = new BarChartData(contractMoney5, "五月");

            start = sdf.parse("2019-06-01 00:00:00");
            end = sdf.parse("2019-6-30 23:59:59");
            double contractMoney6 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData6 = new BarChartData(contractMoney6, "六月");

            start = sdf.parse("2019-07-01 00:00:00");
            end = sdf.parse("2019-7-31 23:59:59");
            double contractMoney7 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData7 = new BarChartData(contractMoney7, "七月");

            start = sdf.parse("2019-08-01 00:00:00");
            end = sdf.parse("2019-8-31 23:59:59");
            double contractMoney8 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData8 = new BarChartData(contractMoney8, "八月");

            start = sdf.parse("2019-09-01 00:00:00");
            end = sdf.parse("2019-9-30 23:59:59");
            double contractMoney9 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData9 = new BarChartData(contractMoney9, "九月");

            start = sdf.parse("2019-010-01 00:00:00");
            end = sdf.parse("2019-10-31 23:59:59");
            double contractMoney10 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData10 = new BarChartData(contractMoney10, "十月");

            start = sdf.parse("2019-11-01 00:00:00");
            end = sdf.parse("2019-11-30 23:59:59");
            double contractMoney11 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData11 = new BarChartData(contractMoney11, "十一月");

            start = sdf.parse("2019-12-01 00:00:00");
            end = sdf.parse("2019-12-31 23:59:59");
            double contractMoney12 = CONTRACTSERVICE.getContractMoney(start, end);
            BarChartData chartData12 = new BarChartData(contractMoney12, "十二月");

            list.add(chartData1);
            list.add(chartData2);
            list.add(chartData3);
            list.add(chartData4);
            list.add(chartData5);
            list.add(chartData6);
            list.add(chartData7);
            list.add(chartData8);
            list.add(chartData9);
            list.add(chartData10);
            list.add(chartData11);
            list.add(chartData12);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.getWriter().write(JSON.toJSONString(list));
    }
}
