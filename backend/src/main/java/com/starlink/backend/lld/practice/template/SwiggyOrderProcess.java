package com.starlink.backend.lld.practice.template;

public class SwiggyOrderProcess extends OrderProcessor{

    public SwiggyOrderProcess(String orderId) {
        super(orderId);
    }

    @Override
    public void doPayment(String orderId) {
        System.out.println("Swiggy paying via cash for orderId="+orderId);
    }

    @Override
    public void orderNotify(String orderId) {
        System.out.println(" Swigggy notifying via whatsapp for orderId="+orderId);
    }
}
