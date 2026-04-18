//package com.starlink.backend.lld.proxy;
//
//// Access control — sirf authorized users
//public class ProtectionProxy implements RestaurantService {
//
//    private final RestaurantService realService;
//    private final String            currentUserRole; // USER, ADMIN, RESTAURANT_OWNER
//
//    public ProtectionProxy(RestaurantService realService, String userRole) {
//        this.realService     = realService;
//        this.currentUserRole = userRole;
//    }
//
//    @Override
//    public Menu getMenu(String restaurantId) {
//        // Sab read kar sakte hain
//        System.out.println("  [PROTECTION] Read allowed for: " + currentUserRole);
//        return realService.getMenu(restaurantId);
//    }
//
//    @Override
//    public void updateMenu(String restaurantId, Menu menu) {
//        // Sirf ADMIN ya RESTAURANT_OWNER update kar sakta hai
//        if (!currentUserRole.equals("ADMIN")
//                && !currentUserRole.equals("RESTAURANT_OWNER")) {
//            throw new SecurityException(
//                "Access denied! Role " + currentUserRole + " cannot update menu.");
//        }
//        System.out.println("  [PROTECTION] Write allowed for: " + currentUserRole);
//        realService.updateMenu(restaurantId, menu);
//    }
//
//    @Override
//    public boolean isAvailable(String restaurantId) {
//        return realService.isAvailable(restaurantId);
//    }
//}