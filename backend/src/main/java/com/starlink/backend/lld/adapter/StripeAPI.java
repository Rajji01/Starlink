package com.starlink.backend.lld.adapter;

class StripeAPI {
    public void charge(double amount) {
        System.out.println("Paid via Stripe: " + amount);
    }
}