package com.xzy.dao.impl;

import com.xzy.dao.BaseDao;
import com.xzy.dao.EmployeeDao;
import com.xzy.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    @Override
    public void addEmployee(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }

    @Override
    public List<Employee> getEmployeeList(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(cn, sql, clazz, args);
    }

    @Override
    public Employee getEmployeeByEmployeeId(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }

    @Override
    public Employee getEmployeeByEmail(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return get(cn, sql, clazz, args);
    }

    @Override
    public void updateEmployee(Connection cn, String sql, Object... args) throws SQLException {
        update(cn, sql, args);
    }
}
