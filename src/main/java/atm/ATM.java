package main.java.atm;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private final BankingService bankingService;
    private final AtomicLong transactionCounter = new AtomicLong(0);
    private final CacheDispenser cacheDispenser;

    public ATM(BankingService bankingService, CacheDispenser cacheDispenser) {
        this.bankingService = bankingService;
        this.cacheDispenser = cacheDispenser;
    }

    //authenticate user
    public void authenticateUser(Card card) {
        //authentication

    }

    //check balance
    public double checkBalance(String accountNumber) {
        return bankingService.getAccount(accountNumber).getBalance();
    }

    //withdraw money
    public void withdrawCash(Account account, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new DebitTransaction(transactionId, account, amount);
        cacheDispenser.dispenseCash(amount);
        bankingService.processPayment(transaction);
    }

    //credit amount
    public void depositCash(Account account, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new CreditTransaction(transactionId, account, amount);
        bankingService.processPayment(transaction);
    }

    private String generateTransactionId() {
        long transactionId = transactionCounter.incrementAndGet();
        return "txn-" + System.currentTimeMillis() + transactionId;
    }
}
