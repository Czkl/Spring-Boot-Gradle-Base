package com.tw.simple.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.tw.simple.dao.base.BaseData;
import com.tw.simple.entity.Employee;
import com.tw.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService {


    private List<Employee> employeeList = BaseData.getEmployeeList();

    @Override
    public String save(Employee employee) {
        if (null != employee) {
            Employee db_employee = getEmployeeById(employee.getId());
            if (db_employee == null) {
                employeeList.add(employee);
                return "add success";
            }
        }
        return "add error . Because the data is incomplete or the Id already exists ";
    }

    @Override
    public String del(Integer employeeId) {
        Employee employee = employeeList.stream()
                .filter(e -> e.getId() == employeeId)
                .findFirst().orElse(null);
        if (employee == null) {
            return "this id not exist";
        } else {
            employeeList.remove(employee);
            return "delete success";
        }
    }

    @Override
    public String upAndSave(Integer employeeId, Employee employee) {

        Employee dbEmployee = employeeList.stream()
                .filter(e->e.getId() == employeeId)
                .findFirst().orElse(null);
        if (dbEmployee == null) {
            return "this id not exist";
        } else {
            dbEmployee.setAge(employee.getAge());
            dbEmployee.setGender(employee.getGender());
            dbEmployee.setName(employee.getName());
        }
        return "update success";
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeList.stream()
                .filter(e -> e.getId() == employeeId)
                .findFirst().orElse(null);
    }
}
