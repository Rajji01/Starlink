package com.starlink.backend.lld.mementodesignpattern.zomato;

import java.util.ArrayList;
import java.util.List;

// Originator
public class ZomatoCart {

    private List<String> items      = new ArrayList<>();
    private double       totalPrice = 0;

    public void addItem(String item, double price) {
        items.add(item);
        totalPrice += price;
        System.out.println("Added: " + item + " | Total: Rs." + totalPrice);
    }

    public void removeItem(String item, double price) {
        items.remove(item);
        totalPrice -= price;
        System.out.println("Removed: " + item + " | Total: Rs." + totalPrice);
    }

    // Save current state
    public CartSnapshot save() {
        return new CartSnapshot(items, totalPrice);
    }

    // Restore previous state
    public void restore(CartSnapshot snap) {
        this.items      = snap.getItems();
        this.totalPrice = snap.getTotalPrice();
        System.out.println("Cart restored: " + items + " | Rs." + totalPrice);
    }
}