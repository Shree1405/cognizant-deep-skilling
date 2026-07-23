package com.cognizant.country_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.country_service.dao.EmployeeDao;
import com.cognizant.country_service.exception.EmployeeNotFoundException;
import com.cognizant.country_service.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        employeeDao.updateEmployee(employee);
    }
    public void deleteEmployee(int id)
            throws EmployeeNotFoundException {

        employeeDao.deleteEmployee(id);
    }
}