package com.starlink.backend.lld.adapter.betterVersion;

public class RazorPayClient {

    public String initiateTransaction(String customerId, int amountInPaise) {
        System.out.println("  [Razorpay SDK] Initiating " + amountInPaise
                + " paise for customer: " + customerId);
        return "RPY_TXN_" + System.currentTimeMillis();
    }

    public boolean cancelTransaction(String txnId) {
        System.out.println("  [Razorpay SDK] Cancelling txn: " + txnId);
        return true;
    }
}