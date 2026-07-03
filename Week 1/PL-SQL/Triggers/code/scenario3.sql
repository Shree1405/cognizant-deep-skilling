CREATE OR REPLACE TRIGGER trg_CheckLoanAmount
BEFORE INSERT OR UPDATE ON Loans
FOR EACH ROW
BEGIN
    IF :NEW.LoanAmount > 100000 THEN
        RAISE_APPLICATION_ERROR(-20003,'Loan Amount exceeds the permitted limit.');
    END IF;
END;
/



SELECT * FROM Loans;