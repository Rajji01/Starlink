package com.starlink.backend.lld.template;

public abstract class OrderProcessor {
    public final void processOrder(String orderId){
        validateOrder(orderId);
        processPayment(orderId);
        notify(orderId);
        assignDelivery(orderId);
    }
    private void validateOrder(String orderId){
        System.out.println("validate orderId="+orderId);
    }
    public abstract void processPayment(String orderId);
    private void notify(String orderId){
        System.out.println("notify orderId="+orderId);
    };
    public abstract void assignDelivery(String orderId);
//    hook method below dummy impl childs are notforced to overide
    public void completeOrderNotify(){}
}
