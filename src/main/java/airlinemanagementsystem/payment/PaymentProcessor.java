package main.java.airlinemanagementsystem.payment;

public enum PaymentProcessor {
    instance;

    public static PaymentProcessor getInstance() {
        return instance;
    }

    public Payment processPayment(Payment payment) {
        // Process payment using the selected payment method
        return payment.processPayment();
    }
}
