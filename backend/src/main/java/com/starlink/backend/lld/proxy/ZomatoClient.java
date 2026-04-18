//package com.starlink.backend.lld.proxy;
//
//import java.util.List;
//
//public class ZomatoClient {
//
//    public static void main(String[] args) {
//
//        System.out.println("=".repeat(55));
//        System.out.println("  PROXY PATTERN — Zomato Restaurant Service");
//        System.out.println("=".repeat(55));
//
//        RealRestaurantService real = new RealRestaurantService();
//
//        // ─── Caching Proxy ────────────────────────────────
//        System.out.println("\n=== Caching Proxy ===");
//        RestaurantService cached = new CachingProxy(real);
//
//        long t1 = System.currentTimeMillis();
//        cached.getMenu("REST_001"); // cache miss — DB call
//        System.out.println("First call: " + (System.currentTimeMillis()-t1) + "ms");
//
//        long t2 = System.currentTimeMillis();
//        cached.getMenu("REST_001"); // cache hit — instant!
//        System.out.println("Second call: " + (System.currentTimeMillis()-t2) + "ms");
//
//        cached.getMenu("REST_001"); // cache hit again
//
//        cached.updateMenu("REST_001", new Menu("REST_001", List.of("Pizza")));
//        cached.getMenu("REST_001"); // cache cleared — DB call again
//
//        // ─── Protection Proxy ─────────────────────────────
//        System.out.println("\n=== Protection Proxy ===");
//        RestaurantService userProxy  = new ProtectionProxy(real, "USER");
//        RestaurantService adminProxy = new ProtectionProxy(real, "ADMIN");
//
//        userProxy.getMenu("REST_002");  // allowed
//
//        try {
//            userProxy.updateMenu("REST_002", new Menu(...)); // blocked!
//        } catch (SecurityException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        adminProxy.updateMenu("REST_002", new Menu(...)); // allowed
//
//        // ─── Virtual Proxy ────────────────────────────────
//        System.out.println("\n=== Virtual Proxy ===");
//        RestaurantService virtual = new VirtualProxy();
//        // Real object abhi nahi bana
//
//        System.out.println("Virtual proxy created — real service not yet initialized");
//        virtual.getMenu("REST_003"); // pehli baar — real service bana
//        virtual.getMenu("REST_003"); // ab real service already hai
//
//        // ─── Proxy Chain — Logging + Caching ──────────────
//        System.out.println("\n=== Proxy Chain ===");
//        RestaurantService chain =
//            new LoggingProxy(
//                new CachingProxy(real)
//            );
//        chain.getMenu("REST_004"); // log → cache miss → real → cache store
//        chain.getMenu("REST_004"); // log → cache hit → return
//    }
//}