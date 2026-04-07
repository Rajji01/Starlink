package com.starlink.backend.lld.adapter.betterVersion;

public class PayUAdapter implements PaymentGateway{
    PayUClient payUClient;

    public PayUAdapter(PayUClient payUClient) {
        this.payUClient = payUClient;
    }

    @Override
    public boolean processPayment(String customerId, double amountInRPs) {
        //fetch mobile number using customerId/userId
        payUClient.makePayment(994897,(float)amountInRPs);
        return true;
    }

    @Override
    public boolean refundPayment(String transactionId) {
        payUClient.initiateRefund(Integer.parseInt(transactionId));
        return true;
    }
}
