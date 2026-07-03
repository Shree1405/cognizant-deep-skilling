CREATE OR REPLACE FUNCTION GetAccountBalance(
    p_accountID NUMBER
)
RETURN NUMBER
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountID;

    RETURN v_balance;
END;
/

SELECT GetAccountBalance(101) AS Balance
FROM Dual;