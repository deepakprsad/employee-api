package com.example.demo.servicesImplement;

import com.example.demo.model.Employee;
import com.example.demo.model.ResponseMessage;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplement implements EmployeeServices {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        try {
            return employeeRepository.findAll();
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        ResponseMessage  responseMessage = new ResponseMessage();
      try {
          Employee employee = employeeRepository.findById(id).orElse(null);
          return employee;
      }catch (Exception e){
          return null;
      }
    }

    @Override
    public String deleteEmployeeById(Long id) {
        try {
             employeeRepository.deleteById(id);
             return "Employee details deleted successfully.";
        }catch (Exception e)
        {
            return "Employee Id not found.";
        }
    }

    @Override
    public String updateEmployeeNameById(Long id, String name) {
        try {
                Employee employee = employeeRepository.findById(id).orElse(null);
                if(name == null || name.equals(""))
                    return "Name is missing.";
                else if(employee == null)
                    return "Employee not found.";
                else {
                    employee.setName(name);
                    employeeRepository.save(employee);
                    return "Employee details updated successfully.";
                }
        }catch(Exception e)
        {
            return e.getMessage();
        }

    }

    @Override
    public String addEmployeeDetails(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Added Employee details successfully.";
        }catch (Exception e)
        {
            return e.getMessage();
        }

    }
}
