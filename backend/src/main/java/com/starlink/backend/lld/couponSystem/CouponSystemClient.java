package com.starlink.backend.lld.couponSystem;

public class CouponSystemClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(60));
        System.out.println("  DECORATOR PATTERN — Sequential Coupon System");
        System.out.println("=".repeat(60));

        // ─── Scenario 1: Samsung TV — multiple coupons ───
        System.out.println("\n--- Samsung TV (Electronics) ---");

        Product tv = new ConcreteProduct(101, "Samsung Electronics TV 55\"", 80000);
        System.out.println("Base price       : Rs." + tv.getPrice());

        // Coupon sequence: Category → Percent → Flat
        // Har wrap previous result pe apply hota hai
        Product afterCategory = new CategoryDiscount(tv);
        System.out.println("After Electronics(-15%): Rs." + afterCategory.getPrice());

        Product afterPercent  = new PercentCoupon(afterCategory, "SAVE10", 10);
        System.out.println("After SAVE10(-10%)     : Rs." + afterPercent.getPrice());

        Product afterFlat     = new FlatCoupon(afterPercent, "FLAT2000", 2000);
        System.out.println("After FLAT2000         : Rs." + afterFlat.getPrice());

        System.out.println("Description: " + afterFlat.getDescription());
        System.out.println("Total saved : Rs." + (tv.getPrice() - afterFlat.getPrice()));

        // ─── Scenario 2: Fashion item — BOGOF ───
        System.out.println("\n--- Zara Fashion Shirt ---");

        Product shirt = new ConcreteProduct(202, "Zara Fashion Shirt", 3000);
        System.out.println("Base price          : Rs." + shirt.getPrice());

        Product afterFashion = new CategoryDiscount(shirt);
        System.out.println("After Fashion(-20%) : Rs." + afterFashion.getPrice());

        Product afterBogof   = new BogofDiscount(afterFashion);
        System.out.println("After BOGOF(-50%)   : Rs." + afterBogof.getPrice());

        System.out.println("Description: " + afterBogof.getDescription());

        // ─── Scenario 3: Order matters — same coupons, different sequence ───
        System.out.println("\n--- Order Matters Demo (Rs.1000 item) ---");

        Product item = new ConcreteProduct(303, "Generic Item", 1000);

        // Sequence A: Flat first, then Percent
        Product seqA = new PercentCoupon(
                           new FlatCoupon(item, "FLAT100", 100),
                           "SAVE10", 10);
        System.out.println("Flat(100) then Percent(10%): Rs." + seqA.getPrice());
        // 1000 - 100 = 900, then 900 * 10% = 90 off → 810

        // Sequence B: Percent first, then Flat
        Product seqB = new FlatCoupon(
                           new PercentCoupon(item, "SAVE10", 10),
                           "FLAT100", 100);
        System.out.println("Percent(10%) then Flat(100): Rs." + seqB.getPrice());
        // 1000 * 10% = 100 off → 900, then 900 - 100 = 800

        System.out.println("Sequence matters! Difference: Rs."
            + Math.abs(seqA.getPrice() - seqB.getPrice()));

        // ─── Scenario 4: No discount category ───
        System.out.println("\n--- Random Product (no category match) ---");

        Product misc = new ConcreteProduct(404, "Random Stationery", 500);
        Product miscWithCategory = new CategoryDiscount(misc);
        System.out.println("Base price    : Rs." + misc.getPrice());
        System.out.println("After category: Rs." + miscWithCategory.getPrice());
        // tera wala bug — ye 0 deta tha, ab 500 dega correctly
    }
}