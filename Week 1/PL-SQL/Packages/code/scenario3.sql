CREATE OR REPLACE PACKAGE AccountPackage AS
    PROCEDURE Deposit(
        p_accountid NUMBER,
        p_amount NUMBER
    );

    PROCEDURE Withdraw(
        p_accountid NUMBER,
        p_amount NUMBER
    );
END AccountPackage;
/

CREATE OR REPLACE PACKAGE BODY AccountPackage AS

    PROCEDURE Deposit(
        p_accountid NUMBER,
        p_amount NUMBER
    )
    IS
    BEGIN
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_accountid;

        COMMIT;
    END;

    PROCEDURE Withdraw(
        p_accountid NUMBER,
        p_amount NUMBER
    )
    IS
    BEGIN
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_accountid;

        COMMIT;
    END;

END AccountPackage;
/

BEGIN
    AccountPackage.Deposit(101,1000);
    AccountPackage.Withdraw(102,500);
END;
/

SELECT * FROM Accounts;