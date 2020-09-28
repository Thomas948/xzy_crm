package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.CustomerDao;
import com.xzy.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {
    @Override
    public void addCustomer(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public void updateCustomer(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public void deleteCustomer(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Customer> getCustomerList(Connection cn, String sql, Class<Customer> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Customer getCustomerByCustomerId(Connection cn, String sql, Class<Customer> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }

    @Override
    public int getCustomerCount(Connection cn, String sql, Object...args) throws SQLException {
        return getCount(cn, sql, args);
    }
}
