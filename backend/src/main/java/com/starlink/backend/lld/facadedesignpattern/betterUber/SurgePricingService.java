package com.starlink.backend.lld.facadedesignpattern.betterUber;

class SurgePricingService {
    public double getSurgeMultiplier(double lat, double lng) {
        // Demand/supply ke hisab se multiplier
        double surge = 1.2;
        System.out.println("Surge pricing: " + surge + "x");
        return surge;
    }
    public double calculateFare(double distanceKm, double surgeMultiplier) {
        double base = 30 + (distanceKm * 12); // Rs.12/km
        return base * surgeMultiplier;
    }
}