// PercentageDiscount.java
package com.starlink.backend.lld.practice.decorator;

public class PercentageDiscount extends DiscountDecorator {

    private final int discountPercentage;

    public PercentageDiscount(BaseProduct baseProduct, int discountPercentage) {
        super(baseProduct);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        int prev     = baseProduct.getPrice();
        int discount = (prev * discountPercentage) / 100;
        return prev - discount;
    }
}