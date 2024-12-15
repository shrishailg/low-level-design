package main.java.payment_recommendation;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId;
    private Map<String, PaymentInstrument> paymentInstruments;
    private boolean upiFlag;

    public User(String userId, boolean upiFlag) {
        this.userId = userId;
        this.upiFlag = upiFlag;
        this.paymentInstruments = new HashMap<>();
    }

    public void addPaymentInstrument(String identifier, PaymentInstrument paymentInstrument) {
        paymentInstruments.put(identifier, paymentInstrument);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, PaymentInstrument> getPaymentInstruments() {
        return paymentInstruments;
    }

    public void setPaymentInstruments(Map<String, PaymentInstrument> paymentInstruments) {
        this.paymentInstruments = paymentInstruments;
    }

    public boolean isUpiFlag() {
        return upiFlag;
    }

    public void setUpiFlag(boolean upiFlag) {
        this.upiFlag = upiFlag;
    }

// Getters
}
