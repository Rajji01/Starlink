package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── STATE INTERFACE ─────────────────────────────────────
public interface OrderState {
    void confirm(Order order);
    void dispatch(Order order);
    void deliver(Order order);
    void cancel(Order order);
    String getStateName();
}