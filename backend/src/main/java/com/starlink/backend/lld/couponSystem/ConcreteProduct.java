package com.starlink.backend.lld.couponSystem;

public class ConcreteProduct extends Product {

    public ConcreteProduct(int prodId, String prodName, int price) {
        super(prodId, prodName, price);
    }

    @Override
    public int getPrice() {
        return price;  // base price — koi discount nahi
    }

    @Override
    public String getDescription() {
        return getProdName();
    }
}