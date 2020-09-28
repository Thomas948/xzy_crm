package com.xzy.test;

import com.xzy.dto.Page;
import com.xzy.entity.Customer;
import com.xzy.service.CustomerService;
import com.xzy.service.impl.CustomerServiceImpl;
import org.junit.Test;

import java.util.Date;

public class TestCustomerService {

    private final CustomerService CUSTOMERSERVICE = new CustomerServiceImpl();

    /*测试添加*/
    @Test
    public void test01() {
        Customer customer = new Customer();
        customer.setCustomerName("猪八戒");
        customer.setPhone("15723456789");
        customer.setStatus(0);
        customer.setPersonLiableId(10002);
        customer.setFounderId(10001);
        customer.setSourceId(10001);
        customer.setIndustryId(10001);
        customer.setLevelId(10000);
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setNextContactTime(new Date());
        customer.setFlag(0);
        CUSTOMERSERVICE.addCustomer(customer);
    }

    /*测试更改*/
    @Test
    public void test02() {
        Customer customer = new Customer();
        customer.setCustomerName("孙悟空");
        customer.setPhone("131234567891");
        customer.setStatus(1);
        customer.setPersonLiableId(10001);
        customer.setFounderId(10000);
        customer.setSourceId(10002);
        customer.setIndustryId(10002);
        customer.setLevelId(10002);
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setNextContactTime(new Date());
        customer.setCustomerId(10004);
        CUSTOMERSERVICE.updateCustomer(customer);
    }

    /*测试删除*/
    @Test
    public void test03() {
        CUSTOMERSERVICE.deleteCustomer(10005);
    }

    /*测试指定id查询*/
    @Test
    public void test04(){
        Customer customer = CUSTOMERSERVICE.getCustomerByCustomerId(10002);
        System.out.println(customer);
    }

    /*测试查询分页数据*/
    @Test
    public void test05() {
        Page page = CUSTOMERSERVICE.getCustomerPages(1, 2, 1,"");
        System.out.println(page);
    }
}
