package com.starlink.backend.lld.proxy;

// Har call log karo — audit trail
public class LoggingProxy implements RestaurantService {

    private final RestaurantService realService;

    public LoggingProxy(RestaurantService realService) {
        this.realService = realService;
    }

    @Override
    public Menu getMenu(String restaurantId) {
        long start = System.currentTimeMillis();
        System.out.println("[LOG] getMenu called — restaurantId: " + restaurantId);

        Menu menu = realService.getMenu(restaurantId);

        long time = System.currentTimeMillis() - start;
        System.out.println("[LOG] getMenu completed in " + time + "ms");
        return menu;
    }

    @Override
    public void updateMenu(String restaurantId, Menu menu) {
        System.out.println("[LOG] updateMenu called — restaurantId: " + restaurantId);
        realService.updateMenu(restaurantId, menu);
        System.out.println("[LOG] updateMenu completed");
    }

    @Override
    public boolean isAvailable(String restaurantId) {
        return realService.isAvailable(restaurantId);
    }
}