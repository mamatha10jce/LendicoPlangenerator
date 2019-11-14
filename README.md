# LendicoPlangenerator
Plan Generator
In order to inform borrowers about the final repayment schedule, we need to have pre-calculated
repayment plans throughout the lifetime of a loan.
To be able to calculate a repayment plan specific input parameters are necessary:
• duration (number of instalments in months)
• nominal interest rate
• total loan amount ("total principal amount")
• Date of Disbursement/Payout
These four parameters need to be input parameters.
The goal is to calculate a repayment plan for an annuity loan. Therefore the amount that the
borrower has to pay back every month, consisting of principal and interest repayments, does not
change (the last instalment might be an exception).
The annuity amount has to be derived from three of the input parameters (duration, nominal
interest rate, total loan amount) before starting the plan calculation.
(use http://financeformulas.net/Annuity_Payment_Formula.html as reference)



