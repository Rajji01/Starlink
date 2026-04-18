package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONCRETE STATE 2 — ConfirmedState ───────────────────
public class ConfirmedState implements OrderState {

    @Override
    public void confirm(Order order) {
        System.out.println("❌ Already confirmed!");
    }

    @Override
    public void dispatch(Order order) {
        System.out.println("✅ Rider assigned — order out for delivery");
        order.setState(new OutForDeliveryState()); // transition!
    }

    @Override
    public void deliver(Order order) {
        System.out.println("❌ Pehle dispatch karo");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("✅ Order cancelled — cancellation fee lagegi");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() { return "CONFIRMED"; }
}