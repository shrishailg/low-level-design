package main.java.paymentrecommendation;

import java.util.Set;

public class BusinessLine {
    private String name;
    private Set allowedPaymentTypes;

    public BusinessLine(String name, Set<PaymentType> allowedPaymentTypes) {
        this.name = name;
        this.allowedPaymentTypes = allowedPaymentTypes;
    }

}
