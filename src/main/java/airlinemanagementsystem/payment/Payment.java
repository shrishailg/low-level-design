package main.java.airlinemanagementsystem.payment;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private double amount;

    public Payment(String paymentId, String paymentMethod, double amount) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
        this.amount = amount;
    }

    public Payment processPayment() {
        this.paymentStatus = PaymentStatus.SUCCESS;
        return this;
    }
}
