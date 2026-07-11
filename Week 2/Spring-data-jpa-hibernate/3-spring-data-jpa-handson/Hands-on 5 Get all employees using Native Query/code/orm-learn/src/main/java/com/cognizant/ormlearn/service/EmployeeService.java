package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.repository.EmployeeRepository;
import java.util.List;
import com.cognizant.ormlearn.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   public List<Employee> getAllEmployeesNative() {
   
       return employeeRepository.getAllEmployeesNative();
   
   }

}