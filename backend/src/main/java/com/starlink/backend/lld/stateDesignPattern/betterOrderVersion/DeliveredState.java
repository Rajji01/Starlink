package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONCRETE STATE 4 — DeliveredState ───────────────────
public class DeliveredState implements OrderState {

    @Override
    public void confirm(Order order) {
        System.out.println("❌ Order already delivered!");
    }

    @Override
    public void dispatch(Order order) {
        System.out.println("❌ Order already delivered!");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("❌ Already delivered!");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("❌ Cannot cancel — already delivered!");
    }

    @Override
    public String getStateName() { return "DELIVERED"; }
}