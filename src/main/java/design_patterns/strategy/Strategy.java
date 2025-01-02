package main.java.design_patterns.strategy;

//Strategy pattern: helps to define multiple algorithms for the task, and we can
// select any algorithm depending on the situation
public class Strategy {
    PayStrategy payStrategy;

    public Strategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void PayTheBills() {
        payStrategy.Pay();
    }
}

interface PayStrategy {
    void Pay();
}

class UpiPay implements PayStrategy {
    public void Pay() {
        System.out.println("upi payment");
    }
}

class creditCardPayment implements PayStrategy {
    public void Pay() {
        System.out.println("credit card payment");
    }
}
