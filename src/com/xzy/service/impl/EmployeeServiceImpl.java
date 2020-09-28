package com.xzy.service.impl;

import com.xzy.dao.EmployeeDao;
import com.xzy.dao.impl.EmployeeDaoImpl;
import com.xzy.entity.Employee;
import com.xzy.entity.Industry;
import com.xzy.service.EmployeeService;
import com.xzy.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao EMPLOYEEDAO = new EmployeeDaoImpl();

    @Override
    public List<Employee> getEmployeeList() {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT employee_id as employeeId,employee_name as employeeName,email FROM employee";
            List<Employee> employeeList = EMPLOYEEDAO.getEmployeeList(cn, sql, Employee.class);
            cn.commit();
            return employeeList;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public Employee getEmployeeByEmployeeId(Integer employeeId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT employee_id as employeeId,employee_name as employeeName FROM employee WHERE employee_id=?";
            Employee employee = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, employeeId);
            cn.commit();
            return employee;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "SELECT employee_id as employeeId,employee_name as employeeName,nick_name as nickName,icon,email,password,remark FROM employee WHERE email=?";
            Employee employee = EMPLOYEEDAO.getEmployeeByEmployeeId(cn, sql, Employee.class, email);
            cn.commit();
            return employee;
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee.getIcon() == null || employee.getIcon().equals("")) {
            employee.setIcon("avatar.jpg");
        }
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "UPDATE employee SET email=?,nick_name=?,icon=?,remark=? WHERE employee_id=?";
            EMPLOYEEDAO.updateEmployee(cn, sql, employee.getEmail(), employee.getNickName(), employee.getIcon(), employee.getRemark(), employee.getEmployeeId());
            cn.commit();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
    }

    @Override
    public void updatePassword(String newPwd, Integer employeeId) {
        Connection cn = null;
        try {
            cn = JdbcUtils.getConnection();
            cn.setAutoCommit(false);
            String sql = "UPDATE employee SET password=? WHERE employee_id=?";
            EMPLOYEEDAO.updateEmployee(cn,sql,newPwd,employeeId);
            cn.commit();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close();
        }
    }
}
