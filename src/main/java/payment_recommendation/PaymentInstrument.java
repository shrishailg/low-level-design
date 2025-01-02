package main.java.payment_recommendation;

public class PaymentInstrument {
    private String identifier;
    private PaymentType type;
    private Issuer issuer;
    private double score;

    public PaymentInstrument(String identifier, PaymentType type, Issuer issuer, double score) {
        this.identifier = identifier;
        this.type = type;
        this.issuer = issuer;
        this.score = score;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
