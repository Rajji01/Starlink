//package com.starlink.backend.lld.proxy;
//
//// Real object tab banao jab pehli baar zaruri ho
//public class VirtualProxy implements RestaurantService {
//
//    // Real object abhi nahi bana — null hai
//    private RestaurantService realService = null;
//
//    // Real object lazily create karo
//    private RestaurantService getRealService() {
//        if (realService == null) {
//            System.out.println("  [VIRTUAL] Creating real service for first time...");
//            realService = new RealRestaurantService(); // tab banao jab zaruri ho
//        }
//        return realService;
//    }
//
//    @Override
//    public Menu getMenu(String restaurantId) {
//        return getRealService().getMenu(restaurantId);
//    }
//
//    @Override
//    public void updateMenu(String restaurantId, Menu menu) {
//        getRealService().updateMenu(restaurantId, menu);
//    }
//
//    @Override
//    public boolean isAvailable(String restaurantId) {
//        return getRealService().isAvailable(restaurantId);
//    }
//}