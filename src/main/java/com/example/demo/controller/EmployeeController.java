package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.ResponseData;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employee")
    public ResponseData getAllEmployee(){
        return employeeServices.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public ResponseData getEmployeeById(@PathVariable Long id){
        return employeeServices.getEmployeeById(id);
    }

    @PostMapping("/employee/add")
    public ResponseData addEmployeeDetails(@RequestBody Employee emp){
        return employeeServices.addEmployeeDetails(emp);
    }

    @PutMapping("/employee/update")
    public ResponseData updateEmployeeName(@RequestParam Long id,@RequestParam String name){
       return employeeServices.updateEmployeeNameById(id, name);
    }

    @DeleteMapping("/employee/delete")
    public ResponseData deleteEmployeeDetails(@RequestParam Long id){
        return  employeeServices.deleteEmployeeById(id);
    }
}
