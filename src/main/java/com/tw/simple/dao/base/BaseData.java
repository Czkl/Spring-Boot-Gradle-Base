package com.tw.simple.dao.base;

import com.tw.simple.entity.Employee;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class BaseData {

    private static volatile List<Employee> employeeList = new ArrayList<>();


    static {
        employeeList.add(new Employee(0,"小明",20,"男"));
        employeeList.add(new Employee(1,"小红",19,"女"));
        employeeList.add(new Employee(2,"小智",15,"男"));
        employeeList.add(new Employee(3,"小刚",25,"男"));
        employeeList.add(new Employee(4,"小霞",15,"女"));
    }

    public static List<Employee> getEmployeeList() {
        if (employeeList == null) {
            synchronized (BaseData.class) {
                if (employeeList == null) {
                    employeeList = new ArrayList<>();
                }
            }
        }
        return employeeList;
    }
}
