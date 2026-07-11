package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        // Uncomment ONLY ONE at a time

        testGetEmployee();

        testAddEmployee();

       testUpdateEmployee();

        context.close();
    }

    private static void testGetEmployee() {

        System.out.println("Start");

        Employee employee = employeeService.get(1);

        System.out.println("Employee : " + employee);
        System.out.println("Department : " + employee.getDepartment());

        System.out.println("End");
    }

    private static void testAddEmployee() throws Exception {

        System.out.println("Start");

        Employee employee = new Employee();

        employee.setName("Rahul");
        employee.setSalary(50000);
        employee.setPermanent(true);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        employee.setDateOfBirth(sdf.parse("1998-10-15"));

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println("Employee Added : " + employee);

        System.out.println("End");
    }

    private static void testUpdateEmployee() {

        System.out.println("Start");

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println("Updated Employee : " + employee);

        System.out.println("End");
    }
}