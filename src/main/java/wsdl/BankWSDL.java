package wsdl;

import java.util.ArrayList;
import java.util.List;

public class BankWSDL implements BankInterface {

    private static final int DEFAULT_CREDIT_SCORE               = 300;
    private static final double INCREMENT_RATE_PERCENT          = 1.05;
    private static final double DECREMENT_RATE_PERCENT          = 1.005;
    private static final double DEFAULT_INTEREST_RATE           = 4.5;
    private static final double DECREASE_INTEREST_RATE_VALUE    = 20;
    private static final double INCREASE_INTEREST_RATE_VALUE    = 10;
    private static final double LOAN_DURATION_RATE              = 1.007;

    @Override
    public String bankName() {
        return "BankWSDL";
    }

    @Override
    public double calculateInterestRate(int customerCreditScore, double loanDuration) {
        return BankInterface.interestRate(
                DEFAULT_CREDIT_SCORE,
                INCREMENT_RATE_PERCENT,
                DECREMENT_RATE_PERCENT,
                customerCreditScore,
                DEFAULT_INTEREST_RATE,
                DECREASE_INTEREST_RATE_VALUE,
                INCREASE_INTEREST_RATE_VALUE,
                loanDuration,
                LOAN_DURATION_RATE
                );
    }

    @Override
    public double refund(double interestrate, double loanAmount, double years) {
        double yearlyRefundRate = loanAmount * ( interestrate / 100 );
        Math.ceil(years);

        for(int counter = 0; counter <= years; counter++) {
            loanAmount += yearlyRefundRate;
        }

        return Math.floor(loanAmount);
    }

    public List<Object> returnWSDLBank(int customerCreditScore, double customerLoanAmount, double loanDuration) {
        List<Object> bankList = new ArrayList<>();
        double interestRate = calculateInterestRate(customerCreditScore, loanDuration);
        bankList.add(bankName());
        bankList.add(interestRate);
        bankList.add(refund(interestRate, customerLoanAmount, loanDuration));

        return bankList;
    }
}
