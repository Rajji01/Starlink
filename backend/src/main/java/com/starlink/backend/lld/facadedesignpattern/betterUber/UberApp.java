package com.starlink.backend.lld.facadedesignpattern.betterUber;// ===== CLIENT — ek line =====

public class UberApp {
    public static void main(String[] args) {

        RideFacade uber = new RideFacade();

        uber.bookRide("USER_123",
            28.6139, 77.2090,   // Delhi pickup
            28.5355, 77.3910);  // Noida drop
    }
}