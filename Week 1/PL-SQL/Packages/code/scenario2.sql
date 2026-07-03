CREATE OR REPLACE PACKAGE EmployeePackage AS
    PROCEDURE HireEmployee(
        p_employeeid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hiredate DATE
    );

    PROCEDURE UpdateEmployeeSalary(
        p_employeeid NUMBER,
        p_salary NUMBER
    );
END EmployeePackage;
/

CREATE OR REPLACE PACKAGE BODY EmployeePackage AS

    PROCEDURE HireEmployee(
        p_employeeid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hiredate DATE
    )
    IS
    BEGIN
        INSERT INTO Employees
        VALUES(
            p_employeeid,
            p_name,
            p_position,
            p_salary,
            p_department,
            p_hiredate
        );

        COMMIT;
    END;

    PROCEDURE UpdateEmployeeSalary(
        p_employeeid NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_employeeid;

        COMMIT;
    END;

END EmployeePackage;
/

BEGIN
    EmployeePackage.HireEmployee(
        6,
        'Vijay',
        'Tester',
        45000,
        'IT',
        SYSDATE
    );

    EmployeePackage.UpdateEmployeeSalary(
        6,
        50000
    );
END;
/

SELECT * FROM Employees;