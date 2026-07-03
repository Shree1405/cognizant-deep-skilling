CREATE OR REPLACE PROCEDURE GenerateMonthlyStatements
IS
    CURSOR trans_cursor IS
        SELECT c.Name,
               a.AccountID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
        ON c.CustomerID = a.CustomerID
        JOIN Transactions t
        ON a.AccountID = t.AccountID
        ORDER BY c.Name;

BEGIN
    FOR rec IN trans_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || rec.Name ||
            ', Account: ' || rec.AccountID ||
            ', Date: ' || TO_CHAR(rec.TransactionDate,'DD-MON-YYYY') ||
            ', Amount: ' || rec.Amount ||
            ', Type: ' || rec.TransactionType
        );
    END LOOP;
END;
/

BEGIN
    GenerateMonthlyStatements;
END;
/