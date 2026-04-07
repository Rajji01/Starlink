package com.starlink.backend.lld.adapter.betterVersion;

public class RazorPayAdapter implements PaymentGateway{
    RazorPayClient razorPayClient;

    public RazorPayAdapter(RazorPayClient razorPayClient) {
        this.razorPayClient = razorPayClient;
    }

    @Override
    public boolean processPayment(String customerId, double amountInRPs) {
        razorPayClient.initiateTransaction(customerId,(int)amountInRPs*100);
        return true;
    }

    @Override
    public boolean refundPayment(String transactionId) {
        razorPayClient.cancelTransaction(transactionId);
        return true;
    }
}
