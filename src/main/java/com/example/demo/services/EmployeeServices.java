package com.example.demo.services;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeServices {

    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    String deleteEmployeeById(Long id);
    String updateEmployeeNameById(Long id, String name);
    String addEmployeeDetails(Employee employee);

}
