package com.example.demo.services;
import com.example.demo.model.Employee;
import com.example.demo.model.ResponseData;

public interface EmployeeServices {

    ResponseData getAllEmployee();
    ResponseData getEmployeeById(Long id);
    ResponseData deleteEmployeeById(Long id);
    ResponseData updateEmployeeNameById(Long id, String name);
    ResponseData addEmployeeDetails(Employee employee);

}
