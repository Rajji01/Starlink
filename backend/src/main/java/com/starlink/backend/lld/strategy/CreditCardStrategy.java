package com.starlink.backend.lld.strategy;

public class CreditCardStrategy implements PaymentStrategy {

    private final String cardNumber;
    private final String cvv;
    private final String expiry;

    public CreditCardStrategy(String cardNumber, String cvv, String expiry) {
        this.cardNumber = cardNumber;
        this.cvv        = cvv;
        this.expiry     = expiry;
    }

    @Override
    public boolean validate() {
        boolean valid = cardNumber != null
            && cardNumber.length() == 16
            && cvv.length() == 3;
        System.out.println("[CARD] Validating card ****"
            + cardNumber.substring(12) + " → " + (valid ? "Valid" : "Invalid"));
        return valid;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[CARD] Connecting to Visa/Mastercard network...");
        System.out.println("[CARD] CVV verification done");
        System.out.println("[CARD] Rs." + amount + " charged to card ****"
            + cardNumber.substring(12));
    }

    @Override
    public String getMethodName() { return "Credit Card"; }
}