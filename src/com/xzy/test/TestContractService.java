package com.xzy.test;

import com.xzy.dto.Page;
import com.xzy.service.ContractService;
import com.xzy.service.impl.ContractServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestContractService {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();

    @Test
    public void test01() {
        Page page = CONTRACTSERVICE.getContractPages(1, 2, "");
        System.out.println(page);
    }

    @Test
    public void test02() {
        System.out.println(CONTRACTSERVICE.getContractByContractId(1));
    }

    @Test
    public void test03() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = sdf.parse("2019-01-01 00:00:00");
            Date end = sdf.parse("2019-01-31 23:59:59");
            double money = CONTRACTSERVICE.getContractMoney(start, end);
            System.out.println(money);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {
        Calendar cal = Calendar.getInstance();
        /*int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("当前时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);*/

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        String start;
        String end;
        if (month < 10) {
            start = year + "-0" + month + "-01 00:00:00";
            end = year + "-0" + month + "31 23:59:59";
        } else {
            start = year + "-" + month + "-01 00:00:00";
            end = year + "-" + month + "-31 23:59:59";
        }
        System.out.println(start);
        System.out.println(end);

    }
}
