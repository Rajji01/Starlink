package com.starlink.backend.lld.couponSystem;

// Coupon 2: Percentage off — SAVE10, SAVE20
public class PercentCoupon extends DiscountDecorator {

    private final String couponCode;
    private final int    discountPercent;  // 10 matlab 10%

    public PercentCoupon(Product product, String couponCode, int discountPercent) {
        super(product);
        this.couponCode      = couponCode;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        int priceAfterWrapped = product.getPrice();
        int discount          = (priceAfterWrapped * discountPercent) / 100;
        return priceAfterWrapped - discount;
    }

    @Override
    public String getDescription() {
        return product.getDescription()
            + " + " + couponCode + "(-" + discountPercent + "%)";
    }
}