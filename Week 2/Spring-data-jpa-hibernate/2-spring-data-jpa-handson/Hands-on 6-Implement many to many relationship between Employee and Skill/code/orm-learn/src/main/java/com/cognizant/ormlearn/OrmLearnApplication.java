package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Uncomment ONLY ONE method at a time

        testGetEmployee();

        // testAddSkillToEmployee();

    }

    private void testGetEmployee() {

        System.out.println("Start");

        Employee employee = employeeService.get(1);

        System.out.println("Employee : " + employee);

        System.out.println("Department : " + employee.getDepartment());

        System.out.println("Skills : " + employee.getSkillList());

        System.out.println("End");
    }

    private void testAddSkillToEmployee() {

        System.out.println("Start");

        // Choose an employee and a skill that are not already related
        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(2);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println("Updated Employee : " + employee);

        System.out.println("End");
    }
}