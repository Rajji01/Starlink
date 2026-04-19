package com.starlink.backend.lld.practice.iterator;

import java.util.ArrayList;
import java.util.List;

public class BreakFastMenu {
    private List<MenuItem> items= new ArrayList<>();
    public BreakFastMenu() {
        items.add(new MenuItem("Idli Sambhar",   60,  "South Indian"));
        items.add(new MenuItem("Masala Dosa",    80,  "South Indian"));
        items.add(new MenuItem("Poha",           50,  "Indian"));
        items.add(new MenuItem("Upma",           55,  "South Indian"));
        items.add(new MenuItem("Bread Toast",    40,  "Continental"));
    }
    public MenuIterator createIterator() {
        return new BreakfastMenuIterator(items);
    }
}
