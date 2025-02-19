package main.java.atm;

import java.util.Map;

public class BankingService {
    private final Map<String, Account> accountMap;

    public BankingService(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public void createAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void processPayment(Transaction transaction) {
        transaction.execute();
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }
}
