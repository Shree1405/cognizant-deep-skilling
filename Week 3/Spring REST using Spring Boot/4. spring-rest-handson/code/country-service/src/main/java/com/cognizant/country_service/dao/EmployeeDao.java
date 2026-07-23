package com.cognizant.country_service.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.country_service.exception.EmployeeNotFoundException;
import com.cognizant.country_service.model.Department;
import com.cognizant.country_service.model.Employee;
import com.cognizant.country_service.model.Skill;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        try {

            Department department = new Department(1, "IT");

            List<Skill> skills = Arrays.asList(
                    new Skill(1, "Java"),
                    new Skill(2, "Spring Boot"));

            employeeList.add(new Employee(
                    1,
                    "John",
                    50000.0,
                    true,
                    new SimpleDateFormat("dd/MM/yyyy").parse("15/08/1998"),
                    department,
                    skills));

            employeeList.add(new Employee(
                    2,
                    "Mary",
                    60000.0,
                    true,
                    new SimpleDateFormat("dd/MM/yyyy").parse("20/05/1997"),
                    department,
                    skills));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void updateEmployee(Employee employee) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId().equals(employee.getId())) {

                employeeList.set(i, employee);
                return;
            }
        }

        throw new EmployeeNotFoundException(
                "Employee not found with id " + employee.getId());
    }public void deleteEmployee(int id) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId().equals(id)) {

                employeeList.remove(i);
                return;
            }
        }

        throw new EmployeeNotFoundException("Employee not found with id " + id);
    }
    
}