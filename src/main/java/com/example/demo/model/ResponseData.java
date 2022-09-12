package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {
    private boolean isSuccessful;
    private String exception;
    private String message;
    private List<Employee> data;


    public boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
    public void setData(Employee data) {
        this.data = new ArrayList<>();
        this.data.add(data);
    }
}
