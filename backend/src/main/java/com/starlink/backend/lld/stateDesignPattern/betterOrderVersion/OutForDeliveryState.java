package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONCRETE STATE 3 — OutForDeliveryState ──────────────
public class OutForDeliveryState implements OrderState {

    @Override
    public void confirm(Order order) {
        System.out.println("❌ Already confirmed aur dispatched!");
    }

    @Override
    public void dispatch(Order order) {
        System.out.println("❌ Already dispatched!");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("✅ Order delivered — enjoy your meal!");
        order.setState(new DeliveredState()); // transition!
    }

    @Override
    public void cancel(Order order) {
        System.out.println("❌ Cannot cancel — rider already on the way!");
    }

    @Override
    public String getStateName() { return "OUT_FOR_DELIVERY"; }
}