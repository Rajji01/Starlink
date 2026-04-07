package com.starlink.backend.lld.facadedesignpattern.betterZomato;

import java.util.List;

class PricingService {
    public double calculateTotal(List<String> items, String promoCode) {
        double base = items.size() * 150.0; // simplified
        double discount = promoCode != null ? base * 0.1 : 0;
        System.out.println("Pricing: Total = " + (base - discount) + " (promo applied: " + (promoCode != null) + ")");
        return base - discount;
    }
}