package main.java.design_patterns.factory;

public class Abstratctfactory {
}


interface Bank{
    String getBankName();
}

class HDFC implements Bank {

    private final String BNAME;

    public HDFC(){
        BNAME="HDFC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}

class ICICI implements Bank{
    private final String BNAME;
    ICICI(){
        BNAME="ICICI BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}

abstract class Loan{
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years)
    {
        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");
    }
}

class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}

class BussinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }

}
