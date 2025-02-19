package main.java.atm;

public class CacheDispenser {
    private double cashAvailable;

    public CacheDispenser(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public void dispenseCash(double amount) {
        if (cashAvailable < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        cashAvailable -= amount;

        System.out.println("Cash dispensed: " + amount);
    }
}
