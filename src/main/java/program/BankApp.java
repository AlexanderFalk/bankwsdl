package program;

import wsdl.BankWSDL;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService
public class BankApp {

    /*private static int customerCreditScore = 300;
    private static int customerLoanAmount = 75000;
    private static double customerLoanDuration = 5;

    public static void main(String[] args) {

        System.out.println(getWSDLBank(customerCreditScore, customerLoanAmount, customerLoanDuration));
    }*/

    @WebMethod
    public static List<Object> getWSDLBank(int customerCreditScore, int customerLoanAmount, double loanDuration) {
        BankWSDL bank = new BankWSDL();
        List<Object> bankList = new ArrayList<>();
        double interestRate = bank.calculateInterestRate(customerCreditScore, loanDuration);
        bankList.add(bank.bankName());
        bankList.add(interestRate);
        bankList.add(bank.refund(interestRate, customerLoanAmount, loanDuration));

        return bankList;
    }

}
