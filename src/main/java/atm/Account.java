package main.java.atm;

public class Account {
    private final String accountNumber;
    private final String customerId;
    private double balance;

    public Account(String accountNumber, String customerId, double balance) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
    }

    public void debitAmount(double amount) {
        balance -= amount;
    }

    public void creditAmount(double amount) {
        balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
