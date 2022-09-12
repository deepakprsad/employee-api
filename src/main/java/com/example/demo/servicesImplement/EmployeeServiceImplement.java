package com.example.demo.servicesImplement;

import com.example.demo.model.Employee;
import com.example.demo.model.ResponseData;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImplement implements EmployeeServices {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public ResponseData getAllEmployee() {
        ResponseData responseData=new ResponseData();
        try {
            var emp= employeeRepository.findAll(Sort.by("id"));
            responseData.setIsSuccessful(true);
            responseData.setMessage("All Employee Details");
            responseData.setData(emp);
            return responseData;

        }catch (Exception e)
        {
            responseData.setIsSuccessful(false);
            responseData.setException(e.getMessage());
            responseData.setMessage("Data not found");
            return responseData;
        }
    }

    @Override
    public ResponseData getEmployeeById(Long id) {
        ResponseData responseData=new ResponseData();
        try {
            Employee employee = employeeRepository.findById(id).orElse(null);

            if(employee !=null){
                responseData.setIsSuccessful(true);
                responseData.setMessage("Employee Details Found");
                responseData.setData(employee);
            }
            else{
                responseData.setIsSuccessful(false);
                responseData.setMessage("Employee id not found");
            }
          return responseData;
      }catch (Exception e){
            responseData.setIsSuccessful(false);
            responseData.setException(e.getMessage());
            responseData.setMessage("Employee not found for id "+id);
            return responseData;
        }
    }

    @Override
    public ResponseData deleteEmployeeById(Long id) {
        ResponseData responseData = new ResponseData();
        try {
             Employee employee = employeeRepository.findById(id).orElse(null);
             employeeRepository.deleteById(id);
            responseData.setIsSuccessful(true);
            responseData.setMessage("Employee Details Deleted Successfully.");
            responseData.setData(employee);
            return responseData;

        }catch (Exception e)
        {
            responseData.setIsSuccessful(false);
            responseData.setMessage("Employee Details not found.");
            responseData.setException(e.getMessage());
            return responseData;
        }
    }

    @Override
    public ResponseData updateEmployeeNameById(Long id, String name) {
        ResponseData responseData = new ResponseData();
        Employee employee = employeeRepository.findById(id).orElse(null);
        try {
                if(name == null || name.equals("")) {
                    responseData.setIsSuccessful(false);
                    responseData.setMessage("Name is missing.");
                    responseData.setData(employee);

                }
                else if(employee == null){
                    responseData.setIsSuccessful(false);
                    responseData.setMessage("Employee not found");
                }
                else {
                    employee.setName(name);
                    employeeRepository.save(employee);
                    responseData.setIsSuccessful(true);
                    responseData.setMessage("Employee details updated successfully.");
                    responseData.setData(employee);
                }
            return responseData;
        }catch(Exception e)
        {
            responseData.setIsSuccessful(false);
            responseData.setException(e.getMessage());
            responseData.setData(employee);
            return responseData;
        }

    }

    @Override
    public ResponseData addEmployeeDetails(Employee employee) {
        ResponseData responseData = new ResponseData();
        try {
            employeeRepository.save(employee);
            responseData.setIsSuccessful(true);
            responseData.setMessage("Added Employee details successfully.");
            responseData.setData(employee);
            return responseData;
        }catch (Exception e)
        {
            responseData.setIsSuccessful(false);
            responseData.setMessage("Employee Details is not added");
            responseData.setException(e.getMessage());
            responseData.setData(employee);
            return responseData;
        }

    }
}
