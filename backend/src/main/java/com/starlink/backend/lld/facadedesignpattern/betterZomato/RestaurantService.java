package com.starlink.backend.lld.facadedesignpattern.betterZomato;

import java.util.List;

class RestaurantService {
    public boolean confirmOrder(String restaurantId, List<String> items) {
        System.out.println("Restaurant " + restaurantId + ": Order confirmed for " + items);
        return true;
    }
    public int estimatePrepTime(String restaurantId) {
        return 25; // minutes
    }
}