package com.cognizant.spring_learn;

import java.util.ArrayList;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;

public class EmployeeTest {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDao();

        ArrayList<Employee> employees = employeeDao.getAllEmployees();

        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }
}