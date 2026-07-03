CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_fromAccount IN NUMBER,
    p_toAccount   IN NUMBER,
    p_amount      IN NUMBER
)
IS
    v_balance NUMBER;
    v_error   VARCHAR2(500);
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_fromAccount;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_fromAccount;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_toAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful.');

EXCEPTION
    WHEN OTHERS THEN
        v_error := SQLERRM;

        ROLLBACK;

        INSERT INTO ErrorLog (ErrorMessage, LogDate)
        VALUES (v_error, SYSDATE);

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Error: ' || v_error);
END;
/