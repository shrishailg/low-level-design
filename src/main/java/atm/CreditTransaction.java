package main.java.atm;

public class CreditTransaction extends Transaction {

    public CreditTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.creditAmount(amount);
    }
}
