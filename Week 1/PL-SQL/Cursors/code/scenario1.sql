CREATE OR REPLACE PROCEDURE DisplayLoanDetails
IS
    CURSOR loan_cursor IS
        SELECT c.CustomerID,
               c.Name,
               l.LoanAmount,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID;

    v_customerid Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_loanamount Loans.LoanAmount%TYPE;
    v_interestrate Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;

    LOOP
        FETCH loan_cursor INTO v_customerid, v_name, v_loanamount, v_interestrate;
        EXIT WHEN loan_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || v_customerid ||
            ', Name: ' || v_name ||
            ', Loan Amount: ' || v_loanamount ||
            ', Interest Rate: ' || v_interestrate
        );
    END LOOP;

    CLOSE loan_cursor;
END;
/

BEGIN
    DisplayLoanDetails;
END;
/