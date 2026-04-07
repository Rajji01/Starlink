package com.starlink.backend.lld.adapter.betterVersion;

// ─── 5. MAIN — Sab Kuch Ek Saath ─────────────────────────────
public class PaytmClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(55));
        System.out.println("  ADAPTER PATTERN — Paytm Payment Gateway");
        System.out.println("=".repeat(55));

        // Razorpay se shuru karo
        PaytmBillingSystem billing = new PaytmBillingSystem(
            new RazorPayAdapter(new RazorPayClient()));
        billing.chargeUser("USER_001", 499.50);
        billing.refundUser("RPY_TXN_123");

        // Stripe pe switch karo — billing system same!
//        billing.setGateway(new StripeAdapter(new StripeClient()));
//        billing.chargeUser("user@gmail.com", 1299.0);

        // PayU pe switch karo
        billing.setGateway(new PayUAdapter(new PayUClient()));
        billing.chargeUser("USER_002", 750.0);
    }
}