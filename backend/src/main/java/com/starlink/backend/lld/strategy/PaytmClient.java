package com.starlink.backend.lld.strategy;

// ─── 4. CLIENT — Real Paytm Usage ────────────────────────
public class PaytmClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(55));
        System.out.println("  STRATEGY PATTERN — Paytm Payment Demo");
        System.out.println("=".repeat(55));

        // UPI se shuru karo
        PaymentService paytm = new PaymentService(
            new UpiStrategy("merchant@okaxis"));
        paytm.processPayment(499.0);

        // ✅ Runtime pe Credit Card pe switch karo
        paytm.setStrategy(
            new CreditCardStrategy("4111111111111234", "123", "12/26"));
        paytm.processPayment(1299.0);

        // ✅ Runtime pe Wallet pe switch karo
        paytm.setStrategy(
            new WalletStrategy("USER_9876", 2000.0));
        paytm.processPayment(750.0);

        // ✅ Net Banking
        paytm.setStrategy(
            new NetBankingStrategy("HDFC", "hdfc_user_001"));
        paytm.processPayment(5000.0);

        // ✅ Insufficient wallet balance scenario
        PaymentService lowBalance = new PaymentService(
            new WalletStrategy("USER_5555", 50.0));
        lowBalance.processPayment(500.0); // balance nahi hai
    }
}