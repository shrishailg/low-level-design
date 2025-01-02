package main.java.payment_recommendation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample usage
        User user = new User("123", true);
        user.addPaymentInstrument("1", new PaymentInstrument("1", PaymentType.CREDIT_CARD, Issuer.HDFC, 0.8));
        user.addPaymentInstrument("2", new PaymentInstrument("2", PaymentType.UPI, Issuer.SBI, 0.9));
        // Add more payment instruments for the user

        Cart cart = new Cart("Credit Card bill payment");
        cart.addItem(new CartItem("Item 1", 100.0));
        cart.addItem(new CartItem("Item 2", 200.0));

        PaymentRecommendationService recommendationService = new PaymentRecommendationService();
        List<PaymentInstrument> recommendedInstruments = recommendationService.recommendPaymentInstruments(user, cart);

        // Output recommended payment instruments
        for (PaymentInstrument instrument : recommendedInstruments) {
            System.out.println("Recommended Payment Instrument: " + instrument.getIdentifier());
        }
    }
}
