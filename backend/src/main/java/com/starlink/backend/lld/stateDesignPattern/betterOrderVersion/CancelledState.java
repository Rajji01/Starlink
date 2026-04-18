package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONCRETE STATE 5 — CancelledState ───────────────────
public class CancelledState implements OrderState {

    @Override
    public void confirm(Order order) {
        System.out.println("❌ Order cancelled hai — reorder karo");
    }

    @Override
    public void dispatch(Order order) {
        System.out.println("❌ Order cancelled hai");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("❌ Order cancelled hai");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("❌ Already cancelled!");
    }

    @Override
    public String getStateName() { return "CANCELLED"; }
}