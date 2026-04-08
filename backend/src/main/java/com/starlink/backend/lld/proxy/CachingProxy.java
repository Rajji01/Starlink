package com.starlink.backend.lld.proxy;

import java.util.HashMap;
import java.util.Map;

// Cache karo — baar baar DB call nahi
public class CachingProxy implements RestaurantService {

    private final RestaurantService realService; // real object
    private final Map<String, Menu> cache = new HashMap<>(); // cache

    public CachingProxy(RestaurantService realService) {
        this.realService = realService;
    }

    @Override
    public Menu getMenu(String restaurantId) {
        // Cache check karo
        if (cache.containsKey(restaurantId)) {
            System.out.println("  [CACHE] Cache hit! Returning cached menu for: "
                + restaurantId);
            return cache.get(restaurantId); // DB call nahi — instant!
        }

        // Cache miss — real object se lo
        System.out.println("  [CACHE] Cache miss — calling real service");
        Menu menu = realService.getMenu(restaurantId);
        cache.put(restaurantId, menu); // cache mein store karo
        return menu;
    }

    @Override
    public void updateMenu(String restaurantId, Menu menu) {
        realService.updateMenu(restaurantId, menu);
        cache.remove(restaurantId); // cache invalidate karo!
        System.out.println("  [CACHE] Cache cleared for: " + restaurantId);
    }

    @Override
    public boolean isAvailable(String restaurantId) {
        return realService.isAvailable(restaurantId); // delegate directly
    }
}