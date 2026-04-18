package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONTEXT — Order ─────────────────────────────────────
public class Order {

    // Current state — ye change hoti rehti hai
    private OrderState currentState;
    private String     orderId;

    public Order(String orderId) {
        this.orderId      = orderId;
        this.currentState = new PlacedState(); // initial state
        System.out.println("Order " + orderId + " created — State: PLACED");
    }

    // ✅ State ko delegate karo — Order ko nahi pata andar kya hoga
    public void confirm()  { currentState.confirm(this); }
    public void dispatch() { currentState.dispatch(this); }
    public void deliver()  { currentState.deliver(this); }
    public void cancel()   { currentState.cancel(this); }

    // State change karne ka method — sirf State classes use karein
    public void setState(OrderState newState) {
        System.out.println("  State: " + currentState.getStateName()
            + " → " + newState.getStateName());
        this.currentState = newState;
    }

    public String getStateName() { return currentState.getStateName(); }
    public String getOrderId()   { return orderId; }
}