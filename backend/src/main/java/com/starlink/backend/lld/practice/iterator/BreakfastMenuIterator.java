package com.starlink.backend.lld.practice.iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class BreakfastMenuIterator implements  MenuIterator{
    private final List<MenuItem> items;
    private       int            position = 0;

    public BreakfastMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) throw new NoSuchElementException("No more items!");
        return items.get(position++);
    }
}
