package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CONCRETE STATE 1 — PlacedState ──────────────────────
public class PlacedState implements OrderState {

    @Override
    public void confirm(Order order) {
        System.out.println("✅ Order confirmed — restaurant ne accept kiya");
        order.setState(new ConfirmedState()); // transition!
    }

    @Override
    public void dispatch(Order order) {
        // Placed se directly dispatch nahi ho sakta
        System.out.println("❌ Pehle confirm karo — dispatch nahi ho sakta");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("❌ Invalid — order abhi placed hai");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("✅ Order cancelled — placed state se cancel possible");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() { return "PLACED"; }
}