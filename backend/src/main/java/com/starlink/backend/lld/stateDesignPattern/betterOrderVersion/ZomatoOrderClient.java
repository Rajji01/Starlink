package com.starlink.backend.lld.stateDesignPattern.betterOrderVersion;

// ─── CLIENT ──────────────────────────────────────────────
public class ZomatoOrderClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(50));
        System.out.println("  STATE PATTERN — Zomato Order Lifecycle");
        System.out.println("=".repeat(50));

        // ─── Happy Path ───────────────────────────────────
        System.out.println("\n=== Happy Path ===");
        Order order1 = new Order("ORD_001");

        order1.confirm();  // PLACED → CONFIRMED
        order1.dispatch(); // CONFIRMED → OUT_FOR_DELIVERY
        order1.deliver();  // OUT_FOR_DELIVERY → DELIVERED

        // ─── Invalid Transitions ─────────────────────────
        System.out.println("\n=== Invalid Transitions ===");
        Order order2 = new Order("ORD_002");

        order2.dispatch(); // PLACED se dispatch — invalid!
        order2.deliver();  // PLACED se deliver — invalid!
        order2.confirm();  // PLACED → CONFIRMED
        order2.confirm();  // Already confirmed — invalid!

        // ─── Cancel Flow ─────────────────────────────────
        System.out.println("\n=== Cancel Flow ===");
        Order order3 = new Order("ORD_003");

        order3.confirm(); // PLACED → CONFIRMED
        order3.cancel();  // CONFIRMED → CANCELLED
        order3.confirm(); // CANCELLED se confirm — invalid!

        // ─── Cancel after dispatch — not allowed ──────────
        System.out.println("\n=== Cancel after Dispatch ===");
        Order order4 = new Order("ORD_004");

        order4.confirm();  // → CONFIRMED
        order4.dispatch(); // → OUT_FOR_DELIVERY
        order4.cancel();   // OUT_FOR_DELIVERY se cancel — not allowed!
        order4.deliver();  // → DELIVERED
    }
}