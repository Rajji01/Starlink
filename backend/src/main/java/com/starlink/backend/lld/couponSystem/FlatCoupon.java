package com.starlink.backend.lld.couponSystem;

// Coupon 1: Flat amount off — FLAT200, FLAT500
public class FlatCoupon extends DiscountDecorator {

    private final String couponCode;
    private final int    discountAmount;

    public FlatCoupon(Product product, String couponCode, int discountAmount) {
        super(product);
        this.couponCode     = couponCode;
        this.discountAmount = discountAmount;
    }

    @Override
    public int getPrice() {
        int priceAfterWrapped = product.getPrice();  // pehle wrapped ka price lo
        int finalPrice        = priceAfterWrapped - discountAmount;
        return Math.max(finalPrice, 0);  // price negative nahi hoga
    }

    @Override
    public String getDescription() {
        return product.getDescription()
            + " + " + couponCode + "(-Rs." + discountAmount + ")";
    }
}