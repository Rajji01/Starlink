package com.starlink.backend.lld.flyweight.paytm;

// Paytm ka apna interface — Zomato wala nahi
public interface TransactionRenderer {
    // Extrinsic state: amount, merchant, timestamp
    void render(double amount, String merchant, long timestamp);
}