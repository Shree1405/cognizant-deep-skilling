CREATE OR REPLACE PACKAGE CustomerPackage AS
    PROCEDURE AddCustomer(
        p_customerid NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomerBalance(
        p_customerid NUMBER,
        p_balance NUMBER
    );
END CustomerPackage;
/

CREATE OR REPLACE PACKAGE BODY CustomerPackage AS

    PROCEDURE AddCustomer(
        p_customerid NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        (CustomerID, Name, DOB, Balance, IsVIP, LastModified)
        VALUES
        (p_customerid, p_name, p_dob, p_balance, 'FALSE', SYSDATE);

        COMMIT;
    END;

    PROCEDURE UpdateCustomerBalance(
        p_customerid NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        UPDATE Customers
        SET Balance = p_balance
        WHERE CustomerID = p_customerid;

        COMMIT;
    END;

END CustomerPackage;
/

BEGIN
    CustomerPackage.AddCustomer(
        6,
        'Ajay',
        DATE '1998-04-12',
        8000
    );

    CustomerPackage.UpdateCustomerBalance(
        6,
        10000
    );
END;
/

SELECT * FROM Customers;