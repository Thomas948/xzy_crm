package com.xzy.test;

import com.xzy.dao.EmployeeDao;
import com.xzy.dao.impl.EmployeeDaoImpl;
import com.xzy.entity.Employee;
import com.xzy.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestEmployeeDao {

    private final EmployeeDao EMPLOYEEDAO = new EmployeeDaoImpl();

    @Test
    public void testAddEmployee() throws SQLException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "INSERT INTO employee (employee_name) values (?)";
        EMPLOYEEDAO.addEmployee(cn,sql,"李四");
    }

    @Test
    public void testGetEmployees() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee";
        List<Employee> employees = EMPLOYEEDAO.getEmployeeList(cn, sql, Employee.class);
        System.out.println(employees);
    }

    @Test
    public void testGetEmployee() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection cn = JdbcUtils.getConnection();
        String sql = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
        Employee employee = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, 10001);
        System.out.println(employee);
    }
}
