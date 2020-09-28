package com.xzy.dao;


import com.xzy.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Connection cn, String sql, Object... args) throws SQLException;

    void updateCustomer(Connection cn, String sql, Object... args) throws SQLException;

    void deleteCustomer(Connection cn, String sql, Object... args) throws SQLException;

    List<Customer> getCustomerList(Connection cn, String sql, Class<Customer> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Customer getCustomerByCustomerId(Connection cn, String sql, Class<Customer> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    int getCustomerCount(Connection cn, String sql, Object...args) throws SQLException;
}
