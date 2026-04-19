package com.starlink.backend.lld.practice.iterator;

// ─── WAITRESS — Client, iterator use karta hai ───────────
// Collection ka internal structure jaanna zaruri nahi!
public class Waitress {

    // ✅ Same method — koi bhi iterator kaam karta hai
    public void printMenu(MenuIterator iterator) {
        System.out.println("-".repeat(45));
        while (iterator.hasNext()) {      // hasNext() — aur hai?
            MenuItem item = iterator.next(); // next() — lo
            System.out.println(item);
        }
    }

    public void printMenuWithPrice(MenuIterator iterator, double maxPrice) {
        System.out.println("Items under Rs." + maxPrice + ":");
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getPrice() <= maxPrice) {
                System.out.println("  " + item);
            }
        }
    }
}