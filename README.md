# WSDL Bank - Loan Broker
This is the WSDL bank for the Loan Broker Project for CPHBusiness Software Development course: System Integration.  
  
## Overview  
You can hook into the banks webservice by sending a request to: 
http://94.130.57.246:9000/bankwsdl/BankAppService?wsdl  
You can also use the tester to try and test the URL:  
http://94.130.57.246:9000/bankwsdl/BankAppService?tester  
  
The webservice needs three arguments to complete the request, as seen in the method below:  

```getWSDLBank(int customerCreditScore, int customerLoanAmount, double loanDuration)``` 

You've probably spotted that you need **CustomerCreditScore**, **CustomerLoanAmount**, **LoanDuration**.  
When you send the request the program will calculate and return: **Bank name, interestrate, and refund amount**.  
  
A request could look like this, where the questionmarks implies an argument.
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:prog="http://program/">
   <soapenv:Header/>
   <soapenv:Body>
      <prog:getWSDLBank>
         <arg0>?</arg0>
         <arg1>?</arg1>
         <arg2>?</arg2>
      </prog:getWSDLBank>
   </soapenv:Body>
</soapenv:Envelope>

```
The interestrate is calculated as followed:  
* The bank has a default credit score value, example **300**  
* It will take the difference between the default value and the customer credit score value  
* A bank has an **incremental**,- and **decrementalvalue**, which indicates when the interestrate will fall or raise. 
* A bank has an **increment,-** and **decrement-rate**, which indicates how much the interest rate will be correlated when the score differes from the default value.
* The **incremental** value could as an example be **20**. This means that everytime the **Customer Credit Score** increments with 20 from the default value, it will decrease the interestrate with a percentage (decrement-rate). This could be **1%** or **5%**. The other way around, with the decremental value, it could be set to 10, which would mean that for every 10 credit points below the default score, it would increase the interestrate for the loan.  
* The bank has a loan-duration-rate applied as well, which indicates a decrement of the loan interest rate for each year extra added to the loan.
