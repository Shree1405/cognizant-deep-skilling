package com.cognizant.country_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.country_service.exception.EmployeeNotFoundException;
import com.cognizant.country_service.model.Employee;
import com.cognizant.country_service.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.info("End");

        return employees;
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody @Valid Employee employee)
            throws EmployeeNotFoundException {

        LOGGER.info("Start");

        employeeService.updateEmployee(employee);

        LOGGER.info("End");
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id)
            throws EmployeeNotFoundException {

        LOGGER.info("Start");

        employeeService.deleteEmployee(id);

        LOGGER.info("End");
    }
}