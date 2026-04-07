package com.starlink.backend.lld.adapter.betterVersion;

// ─── 4. CLIENT — Paytm Billing System ────────────────────────
// Client ko pata nahi andar kaunsa gateway hai — sirf PaymentGateway use karta hai
public class PaytmBillingSystem {

    private PaymentGateway gateway; // Target interface

    public PaytmBillingSystem(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    // Runtime pe gateway switch karo
    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
//        System.out.println("\n[SWITCH] Gateway changed to: " + gateway.getGatewayName());
    }

    public void chargeUser(String userId, double amount) {
//        System.out.println("\n--- Charging " + userId
//            + " Rs." + amount + " via " + gateway.getGatewayName() + " ---");

        boolean success = gateway.processPayment(userId, amount);

        System.out.println("  Result: " + (success ? "SUCCESS" : "FAILED"));
    }

    public void refundUser(String txnId) {
        System.out.println("\n--- Refunding txn: " + txnId + " ---");
        boolean success = gateway.refundPayment(txnId);
        System.out.println("  Refund: " + (success ? "SUCCESS" : "FAILED"));
    }
}