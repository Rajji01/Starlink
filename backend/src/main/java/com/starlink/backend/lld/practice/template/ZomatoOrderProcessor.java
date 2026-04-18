package com.starlink.backend.lld.practice.template;

public class ZomatoOrderProcessor extends OrderProcessor{
    public ZomatoOrderProcessor(String orderId) {
        super(orderId);
    }

    @Override
    public void doPayment(String orderId) {
        System.out.println("Zomato paying via upi for orderId="+orderId);
    }

    @Override
    public void orderNotify(String orderId) {
        System.out.println("Zomato notifying via email for orderId="+orderId);
    }
}
