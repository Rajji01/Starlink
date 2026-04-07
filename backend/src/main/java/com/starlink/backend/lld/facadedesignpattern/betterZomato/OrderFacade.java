package com.starlink.backend.lld.facadedesignpattern.betterZomato;// ===== ZOMATO FACADE =====

import java.util.List;

class OrderFacade {

    private final RestaurantService restaurantService;
    private final DeliveryService   deliveryService;
    private final PricingService    pricingService;
    private final TrackingService   trackingService;

    public OrderFacade() {
        this.restaurantService = new RestaurantService();
        this.deliveryService   = new DeliveryService();
        this.pricingService    = new PricingService();
        this.trackingService   = new TrackingService();
    }

    public OrderSummary placeOrder(String restaurantId,
                                   List<String> items,
                                   String deliveryLocation,
                                   String promoCode) {

        // 1. Restaurant confirm karo
        if (!restaurantService.confirmOrder(restaurantId, items)) {
            throw new RuntimeException("Restaurant unavailable");
        }

        // 2. Price calculate karo
        double total = pricingService.calculateTotal(items, promoCode);

        // 3. Delivery partner assign karo
        String partnerId = deliveryService.assignDeliveryPartner(deliveryLocation);

        // 4. ETA calculate karo
        int eta = restaurantService.estimatePrepTime(restaurantId)
                + deliveryService.estimateDeliveryTime(deliveryLocation);

        // 5. Tracking start karo
        String orderId = "ORD_" + System.currentTimeMillis();
        trackingService.initTracking(orderId, partnerId);

        return new OrderSummary(orderId, total, eta);
    }
}