package com.xzy.dao;

import com.xzy.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void addEmployee(Connection cn, String sql, Object... args) throws SQLException;

    List<Employee> getEmployeeList(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Employee getEmployeeByEmployeeId(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    Employee getEmployeeByEmail(Connection cn, String sql, Class<Employee> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    void updateEmployee(Connection cn, String sql, Object... args) throws SQLException;

}
