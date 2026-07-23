package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;


@Service
public class EmployeeService {


    private EmployeeDao employeeDao = new EmployeeDao();


    @Transactional
    public ArrayList<Employee> getAllEmployees(){

        return employeeDao.getAllEmployees();

    }

}