// BaseProduct.java
package com.starlink.backend.lld.practice.decorator;

public class BaseProduct {
    protected int price;

    public BaseProduct(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}