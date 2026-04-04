package com.starlink.backend.lld.template;

public class SwiggyOrderProcessor extends OrderProcessor{
    @Override
    public void processPayment(String orderId) {

        System.out.println("payed using razorPay for Swiggy ="+orderId);
    }

    @Override
    public void assignDelivery(String orderId) {
        System.out.println("assign Delivery for swiggy ="+orderId);
    }
}
