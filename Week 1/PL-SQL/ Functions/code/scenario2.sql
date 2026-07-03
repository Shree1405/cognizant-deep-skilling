CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loanAmount NUMBER,
    p_interestRate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_monthlyRate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthlyRate := p_interestRate / (12 * 100);
    v_months := p_years * 12;

    v_emi := (p_loanAmount * v_monthlyRate * POWER(1 + v_monthlyRate, v_months))
             / (POWER(1 + v_monthlyRate, v_months) - 1);

    RETURN ROUND(v_emi,2);
END;
/

SELECT LoanID,
       LoanAmount,
       InterestRate,
       CalculateMonthlyInstallment(LoanAmount, InterestRate, 5) AS EMI
FROM Loans;