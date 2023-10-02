package com.example.EmployeeManagementCrud.DAO;


import com.example.EmployeeManagementCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee createEmployee(Employee employee);

    void deleteEmployeeByID(int id);

}
