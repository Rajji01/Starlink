package com.starlink.backend.lld.strategy;

// ─── 1. STRATEGY INTERFACE ────────────────────────────────
// Sab payment methods ka common contract
public interface PaymentStrategy {
    void pay(double amount);
    boolean validate(); // payment details valid hain?
    String getMethodName();
}