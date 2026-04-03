package com.starlink.backend.lld.mementodesignpattern.zomato;

import java.util.ArrayList;
import java.util.List;

final class CartSnapshot {
    private final List<String> items;
    private final double       totalPrice;

    CartSnapshot(List<String> items, double totalPrice) {
        this.items      = new ArrayList<>(items); // deep copy!
        this.totalPrice = totalPrice;
    }

    List<String> getItems()      { return new ArrayList<>(items); }
    double       getTotalPrice() { return totalPrice; }
}