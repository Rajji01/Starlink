package com.starlink.backend.lld.facadedesignpattern.betterZomato;

class DeliveryService {
    public String assignDeliveryPartner(String location) {
        System.out.println("Delivery: Partner assigned near " + location);
        return "PARTNER_" + (int)(Math.random() * 1000);
    }
    public int estimateDeliveryTime(String location) {
        return 15; // minutes
    }
}