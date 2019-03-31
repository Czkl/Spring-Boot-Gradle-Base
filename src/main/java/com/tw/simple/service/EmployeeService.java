package com.tw.simple.service;

import com.tw.simple.entity.Employee;

public interface EmployeeService {


    String save(Employee employee);

    String del(Integer employeeId);

    String upAndSave(Integer employeeId, Employee employee);

    Employee getEmployeeById(Integer employeeId);
}
