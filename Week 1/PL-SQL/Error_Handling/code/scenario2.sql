
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employeeID IN NUMBER,
    p_increment  IN NUMBER
)
IS
    v_count NUMBER;
    v_error VARCHAR2(500);
BEGIN
    
    SELECT COUNT(*)
    INTO v_count
    FROM Employees
    WHERE EmployeeID = p_employeeID;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee does not exist.');
    END IF;

    
    UPDATE Employees
    SET Salary = Salary + p_increment
    WHERE EmployeeID = p_employeeID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN OTHERS THEN
        v_error := SQLERRM;

        ROLLBACK;

        INSERT INTO ErrorLog(ErrorMessage, LogDate)
        VALUES(v_error, SYSDATE);

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Error: ' || v_error);
END;
/


BEGIN
    UpdateSalary(2,5000);
END;
/



SELECT EmployeeID, Name, Salary
FROM Employees
ORDER BY EmployeeID;



BEGIN
    UpdateSalary(10,5000);
END;
/


SELECT *
FROM ErrorLog
ORDER BY LogID;