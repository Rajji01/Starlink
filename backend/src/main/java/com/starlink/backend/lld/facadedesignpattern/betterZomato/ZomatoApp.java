package com.starlink.backend.lld.facadedesignpattern.betterZomato;// ===== CLIENT =====

import java.util.Arrays;

public class ZomatoApp {
    public static void main(String[] args) {

        OrderFacade zomato = new OrderFacade();

        // Ek method call — sab ho gaya
        zomato.placeOrder(
            "REST_456",
            Arrays.asList("Butter Chicken", "Naan", "Raita"),
            "Sector 15, Faridabad",
            "FLAT10"
        );
    }
}