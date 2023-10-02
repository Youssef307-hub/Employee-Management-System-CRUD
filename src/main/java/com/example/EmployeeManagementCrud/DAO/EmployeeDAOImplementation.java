package com.example.EmployeeManagementCrud.DAO;

import com.example.EmployeeManagementCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Query for all the employees
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // Save the returned employees into a List
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        // merge will insert the newEmployee into the database if it doesn't exist as it's Id will be 0
        // else if the employee already exists so it will update the employee
        Employee newEmployee = entityManager.merge(employee);

        return newEmployee;
    }

    @Override
    public void deleteEmployeeByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
