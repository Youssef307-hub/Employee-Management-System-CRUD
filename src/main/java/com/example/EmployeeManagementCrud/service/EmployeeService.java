package com.example.EmployeeManagementCrud.service;

import com.example.EmployeeManagementCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee createEmployee(Employee employee);

    void deleteEmployeeByID(int id);

}