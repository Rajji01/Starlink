package com.starlink.backend.lld.adapter.betterVersion;

public interface PaymentGateway {
    public boolean processPayment(String customerId,double amountInRPs);
    public boolean refundPayment(String transactionId);
}
