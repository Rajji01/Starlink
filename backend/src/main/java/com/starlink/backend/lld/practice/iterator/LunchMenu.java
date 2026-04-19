package com.starlink.backend.lld.practice.iterator;

// ─── COLLECTION 2 — Array based menu ─────────────────────
public class LunchMenu {

    private static final int MAX_ITEMS = 10;
    private final MenuItem[] items;
    private       int        numberOfItems = 0;

    public LunchMenu() {
        items = new MenuItem[MAX_ITEMS];
        items[numberOfItems++] = new MenuItem("Butter Chicken",  320, "North Indian");
        items[numberOfItems++] = new MenuItem("Dal Makhani",     180, "North Indian");
        items[numberOfItems++] = new MenuItem("Jeera Rice",      120, "Indian");
        items[numberOfItems++] = new MenuItem("Tandoori Roti",    30, "Indian");
        items[numberOfItems++] = new MenuItem("Raita",            60, "Indian");
    }

    public MenuIterator createIterator() {
        return new LunchMenuIterator(items, numberOfItems);
    }
}
