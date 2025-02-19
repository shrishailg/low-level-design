package main.java.atm;

public class DebitTransaction extends Transaction {

    public DebitTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.debitAmount(amount);
    }
}
