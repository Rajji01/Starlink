package com.starlink.backend.lld.couponSystem;

// Coupon 4: Buy 1 Get 1 — 50% off
public class BogofDiscount extends DiscountDecorator {

    public BogofDiscount(Product product) {
        super(product);
    }

    @Override
    public int getPrice() {
        return product.getPrice() / 2;  // 50% off = buy 1 get 1
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + BOGOF(-50%)";
    }
}