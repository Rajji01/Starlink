package com.starlink.backend.lld.facadedesignpattern.betterZomato;

// Simple response object
class OrderSummary {
    String orderId;
    double totalAmount;
    int etaMinutes;

    OrderSummary(String orderId, double totalAmount, int etaMinutes) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.etaMinutes = etaMinutes;
        System.out.println("ORDER PLACED! ID: " + orderId
            + " | Total: Rs." + totalAmount
            + " | ETA: " + etaMinutes + " mins");
    }
}