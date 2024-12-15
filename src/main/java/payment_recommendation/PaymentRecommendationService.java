package main.java.payment_recommendation;

import java.util.*;

public class PaymentRecommendationService {
    public List<PaymentInstrument> recommendPaymentInstruments(User user, Cart cart) {
        List<PaymentInstrument> recommendedInstruments = new ArrayList<>();
        Set<PaymentType> allowedPaymentTypes = getAllowedPaymentTypes(cart);

        for (PaymentInstrument instrument : user.getPaymentInstruments().values()) {
            if (allowedPaymentTypes.contains(instrument.getType())) {
                if (!(instrument.getType() == PaymentType.UPI && !user.isUpiFlag())) {
                    recommendedInstruments.add(instrument);
                }
            }
        }

        // Implement ordering logic here if needed

        return recommendedInstruments;
    }

    private Set<PaymentType> getAllowedPaymentTypes(Cart cart) {
        // Logic to determine allowed payment types based on cart's business line
        // This can be extended to accommodate future business lines
        Set<PaymentType> allowedPaymentTypes = new HashSet<>();

        switch (cart.getBusinessLine()) {
            case "Credit Card bill payment":
                allowedPaymentTypes.addAll(Arrays.asList(PaymentType.UPI, PaymentType.DEBIT_CARD, PaymentType.NETBANKING));
                break;
            case "Commerce":
                allowedPaymentTypes.addAll(Arrays.asList(PaymentType.CREDIT_CARD, PaymentType.UPI, PaymentType.DEBIT_CARD));
                break;
            case "Investment":
                allowedPaymentTypes.addAll(Arrays.asList(PaymentType.UPI, PaymentType.NETBANKING));
                break;
            // Add cases for future business lines here
        }

        return allowedPaymentTypes;
    }
}
