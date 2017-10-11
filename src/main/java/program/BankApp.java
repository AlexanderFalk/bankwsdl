package program;

import wsdl.BankWSDL;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService
public class BankApp {

    private BankWSDL bank = new BankWSDL();

    public List<Object> getWSDLBank(int customerCreditScore, int customerLoanAmount, double loanDuration) {
        return bank.returnWSDLBank(customerCreditScore, customerLoanAmount, loanDuration);
    }

}
