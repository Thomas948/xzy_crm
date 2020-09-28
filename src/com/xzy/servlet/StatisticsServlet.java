package com.xzy.servlet;

import com.alibaba.fastjson.JSON;
import com.xzy.service.ContractService;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.ContractServiceImpl;
import com.xzy.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();
    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> list = new ArrayList<>();

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        String start;
        String end;
        try {
            if (month < 10) {
                start = year + "-0" + month + "-01 00:00:00";
                end = year + "-0" + month + "-31 23:59:59";
            } else {
                start = year + "-" + month + "-01 00:00:00";
                end = year + "-" + month + "-31 23:59:59";
            }

            Date dateStart = sdf.parse(start);
            Date dateEnd = sdf.parse(end);
            double amountMonth = CONTRACTSERVICE.getContractMoney(dateStart, dateEnd);
            BigDecimal mData = new BigDecimal(amountMonth).setScale(2, BigDecimal.ROUND_HALF_UP);
            String value = String.valueOf(mData);
            list.add(value);

            year-=1;
            start = year + "-01-01 00:00:00";
            end = year + "-12-31 23:59:59";
            dateStart = sdf.parse(start);
            dateEnd = sdf.parse(end);
            double amountLastYear = CONTRACTSERVICE.getContractMoney(dateStart, dateEnd);
            mData = new BigDecimal(amountLastYear).setScale(2, BigDecimal.ROUND_HALF_UP);
            value = String.valueOf(mData);
            list.add(value);

            int customerIncrementLastYear = CUSTOMERSERVICE.getCustomerCount(dateStart, dateEnd);
            list.add(String.valueOf(customerIncrementLastYear));

            start = "1970-01-01 00:00:00";
            dateStart = sdf.parse(start);
            dateEnd = new Date();
            int customerCount = CUSTOMERSERVICE.getCustomerCount(dateStart, dateEnd);
            list.add(String.valueOf(customerCount));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.getWriter().write(JSON.toJSONString(list));
    }
}
