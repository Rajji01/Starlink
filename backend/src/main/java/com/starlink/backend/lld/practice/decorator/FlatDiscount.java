// FlatDiscount.java
package com.starlink.backend.lld.practice.decorator;

public class FlatDiscount extends DiscountDecorator {

    public FlatDiscount(BaseProduct baseProduct) {
        super(baseProduct);
    }

    @Override
    public int getPrice() {
        return baseProduct.getPrice() - 10;
    }
}