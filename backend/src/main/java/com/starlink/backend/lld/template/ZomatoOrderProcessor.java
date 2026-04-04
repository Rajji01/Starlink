package com.starlink.backend.lld.template;

public class ZomatoOrderProcessor extends OrderProcessor{
    @Override
    public void processPayment(String orderId) {
        System.out.println("payed using paytm for zomato ="+orderId);
    }

    @Override
    public void assignDelivery(String orderId) {
        System.out.println("assign delivery  for zomato ="+orderId);
    }
}
