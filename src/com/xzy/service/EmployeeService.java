package com.xzy.service;

import com.xzy.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    Employee getEmployeeByEmployeeId(Integer employeeId);

    Employee getEmployeeByEmail(String email);

    void updateEmployee(Employee employee);

    void updatePassword(String newPwd, Integer employeeId);
}
