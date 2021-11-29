package com.example.springviewinjection.service;

import com.example.springviewinjection.model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    void save(Employee employee);
}
