CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    v_error VARCHAR2(500);
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

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
    ProcessMonthlyInterest;
END;
/

SELECT AccountID,
       CustomerID,
       AccountType,
       Balance
FROM Accounts
ORDER BY AccountID;

SELECT *
FROM ErrorLog
ORDER BY LogID;