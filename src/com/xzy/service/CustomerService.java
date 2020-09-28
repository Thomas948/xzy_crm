package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    void updateCustomer(Customer customer);

    Page getCustomerPages(int pageNo, int pageSize, int flag, String keyword);

    Customer getCustomerByCustomerId(Integer customerId);

    List<Customer> getCustomerList(int flag);

    /**
     * 查时间段用户增长
     */
    int getCustomerCount(Date start,Date end);
}
