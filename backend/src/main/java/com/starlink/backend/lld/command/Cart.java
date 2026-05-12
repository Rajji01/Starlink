package com.starlink.backend.lld.command;

import java.util.ArrayList;
import java.util.List;

// ─── RECEIVER — actual kaam karta hai ────────────────────
public class Cart {
    private List<String> items = new ArrayList<>();
    private double       total = 0;

    public void addItem(String item, double price) {
        items.add(item);
        total += price;
        System.out.println("  [Cart] Added: " + item 
            + " | Total: Rs." + total);
    }

    public void removeItem(String item, double price) {
        items.remove(item);
        total -= price;
        System.out.println("  [Cart] Removed: " + item 
            + " | Total: Rs." + total);
    }

    public void applyDiscount(double discount) {
        total -= discount;
        System.out.println("  [Cart] Discount applied: Rs." + discount
            + " | Total: Rs." + total);
    }

    public void removeDiscount(double discount) {
        total += discount;
        System.out.println("  [Cart] Discount removed | Total: Rs." + total);
    }

    public List<String> getItems() { return items; }
    public double       getTotal() { return total; }
}