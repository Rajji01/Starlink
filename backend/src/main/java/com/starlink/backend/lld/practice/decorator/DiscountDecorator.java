// DiscountDecorator.java
package com.starlink.backend.lld.practice.decorator;

public abstract class DiscountDecorator extends BaseProduct {
    protected BaseProduct baseProduct;

    public DiscountDecorator(BaseProduct baseProduct) {
        super(baseProduct.getPrice());
        this.baseProduct = baseProduct;
    }
}