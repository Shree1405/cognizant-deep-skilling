CREATE OR REPLACE PROCEDURE UpdateSeniorCitizenInterest
IS
    CURSOR cust_cursor IS
        SELECT c.CustomerID,
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) Age
        FROM Customers c;

BEGIN
    FOR rec IN cust_cursor LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
END;
/

BEGIN
    UpdateSeniorCitizenInterest;
END;
/

SELECT CustomerID,
       InterestRate
FROM Loans
ORDER BY CustomerID;