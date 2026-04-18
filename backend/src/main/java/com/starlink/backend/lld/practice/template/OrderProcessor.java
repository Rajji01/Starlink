package com.starlink.backend.lld.practice.template;

public abstract class OrderProcessor {
    private String orderId;

    public OrderProcessor(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void processOrder(){
        orderInitiate(orderId);
        doPayment(orderId);
        orderPrepare(orderId);
        orderComplete(orderId);
        orderNotify(orderId);
    }
    public void orderInitiate(String orderId){
        System.out.println(" order initiate order id="+orderId);
    }
    public abstract void doPayment(String orderId);
    public void orderComplete(String orderId){
        System.out.println(" order orderComplete order id="+orderId);
    }
    public void orderPrepare(String orderId){
        System.out.println(" order orderPrepare order id="+orderId);
    }
    public abstract  void orderNotify(String orderId);
}
