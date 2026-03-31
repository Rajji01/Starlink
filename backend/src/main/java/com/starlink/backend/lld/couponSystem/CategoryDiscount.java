package com.starlink.backend.lld.couponSystem;

// Coupon 3: Category based — Electronics 15% off, Fashion 20% off
public class CategoryDiscount extends DiscountDecorator {

    // Category → discount percent mapping
    private static final java.util.Map<String, Integer> CATEGORY_DISCOUNTS
        = new java.util.HashMap<>();

    static {
        CATEGORY_DISCOUNTS.put("Electronics", 15);
        CATEGORY_DISCOUNTS.put("Fashion",     20);
        CATEGORY_DISCOUNTS.put("Grocery",      5);
        CATEGORY_DISCOUNTS.put("Books",       10);
    }

    public CategoryDiscount(Product product) {
        super(product);
    }

    @Override
    public int getPrice() {
        int priceAfterWrapped = product.getPrice();

        // Product name se category dhundo
        for (java.util.Map.Entry<String, Integer> entry
                : CATEGORY_DISCOUNTS.entrySet()) {

            if (product.getProdName().contains(entry.getKey())) {
                int discount = (priceAfterWrapped * entry.getValue()) / 100;
                return priceAfterWrapped - discount;
            }
        }

        return priceAfterWrapped;  // ← tera bug fix — 0 nahi, original return
    }

    @Override
    public String getDescription() {
        for (java.util.Map.Entry<String, Integer> entry
                : CATEGORY_DISCOUNTS.entrySet()) {
            if (product.getProdName().contains(entry.getKey())) {
                return product.getDescription()
                    + " + CategoryDeal(-" + entry.getValue() + "%)";
            }
        }
        return product.getDescription();
    }
}