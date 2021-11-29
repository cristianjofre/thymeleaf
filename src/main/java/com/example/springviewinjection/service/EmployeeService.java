package com.example.springviewinjection.service;

import com.example.springviewinjection.model.Employee;
import com.example.springviewinjection.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements  IEmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }
}
