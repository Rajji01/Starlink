package com.starlink.backend.lld.practice.iterator;

import java.util.NoSuchElementException;

// LunchMenu ka Iterator — Array traverse karta hai
public class LunchMenuIterator implements MenuIterator {

    private final MenuItem[] items;
    private final int        maxItems;
    private       int        position = 0;

    public LunchMenuIterator(MenuItem[] items, int maxItems) {
        this.items    = items;
        this.maxItems = maxItems;
    }

    @Override
    public boolean hasNext() {
        return position < maxItems && items[position] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) throw new NoSuchElementException("No more items!");
        return items[position++];
    }
}