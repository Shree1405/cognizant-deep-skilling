CREATE OR REPLACE TRIGGER trg_LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog(TransactionID, ActionDate, Message)
    VALUES(:NEW.TransactionID,
           SYSDATE,
           'Transaction Successfully Added');
END;
/

INSERT INTO Transactions
VALUES(306,101,SYSDATE,1000,'Deposit');

SELECT * FROM AuditLog;