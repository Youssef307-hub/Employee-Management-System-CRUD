package com.example.EmployeeManagementCrud.controller;

import com.example.EmployeeManagementCrud.DAO.EmployeeDAO;
import com.example.EmployeeManagementCrud.entity.Employee;
import com.example.EmployeeManagementCrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        // To force the controller to create new employee instead of update we set the id to 0
        employee.setId(0);

        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }
        employeeService.deleteEmployeeByID(employeeId);

        return "Employee with ID -" + employeeId + " got deleted!";
    }
}
