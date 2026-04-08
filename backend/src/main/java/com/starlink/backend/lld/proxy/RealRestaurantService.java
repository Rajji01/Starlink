package com.starlink.backend.lld.proxy;

// ─── REAL OBJECT — actual DB kaam karta hai ──────────────
public class RealRestaurantService implements RestaurantService {

    @Override
    public Menu getMenu(String restaurantId) {
        System.out.println("  [REAL] DB call — fetching menu for: " + restaurantId);
        simulateDBCall(); // 500ms
        return new Menu(restaurantId, List.of("Biryani", "Naan", "Dal", "Raita"));
    }

    @Override
    public void updateMenu(String restaurantId, Menu menu) {
        System.out.println("  [REAL] DB update — saving menu for: " + restaurantId);
        simulateDBCall();
    }

    @Override
    public boolean isAvailable(String restaurantId) {
        System.out.println("  [REAL] Checking availability: " + restaurantId);
        return true;
    }

    private void simulateDBCall() {
        try { Thread.sleep(500); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}