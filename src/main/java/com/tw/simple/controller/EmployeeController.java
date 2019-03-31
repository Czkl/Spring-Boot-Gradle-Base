package com.tw.simple.controller;


import com.tw.simple.dao.base.BaseData;
import com.tw.simple.entity.Employee;
import com.tw.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    /**
     * 查询所有employee列表
     *
     * @return
     */
    @GetMapping (value = "/employees")
    public List employees() {
        return BaseData.getEmployeeList();
    }

    /**
     * 返回指定Id的employee信息
     * @param employeeId
     * @return
     */
    @GetMapping (value = "/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {

        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * 新增一个或多个employee
     *
     * @param employee
     * @return
     */
    @PostMapping (value = "/employees")
    public String addEmployees( @RequestBody  Employee employee) {
        //"新增一个或多个employee"
        return employeeService.save(employee);
    }


    /**
     * 更新一个employee信息
     * @param employeeId
     * @return
     */
    @PostMapping (value = "/employees/{employeeId}")
    public String updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee employee) {

        return employeeService.upAndSave(employeeId,employee);
    }


    /**
     * 删除指定id的employee
     * @param employeeId
     * @return
     */
    @DeleteMapping (value = "/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {

//        "删除指定id的employee"
        return employeeService.del(employeeId);
    }


}
