package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeServices.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeServices.getEmployeeById(id);
    }

    @PostMapping("/employee/add")
    public String addEmployeeDetails(@RequestBody Employee emp){
        return employeeServices.addEmployeeDetails(emp);
    }

    @PutMapping("/employee/update")
    public String updateEmployeeName(@RequestParam Long id,@RequestParam String name){
       return employeeServices.updateEmployeeNameById(id, name);
    }

    @DeleteMapping("/employee/delete")
    public String deleteEmployeeDetails(@RequestParam Long id){
        return  employeeServices.deleteEmployeeById(id);
    }
}
