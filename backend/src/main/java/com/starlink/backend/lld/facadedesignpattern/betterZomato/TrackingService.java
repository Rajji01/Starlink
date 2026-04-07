package com.starlink.backend.lld.facadedesignpattern.betterZomato;

class TrackingService {
    public void initTracking(String orderId, String partnerId) {
        System.out.println("Tracking started for order " + orderId + " with partner " + partnerId);
    }
}