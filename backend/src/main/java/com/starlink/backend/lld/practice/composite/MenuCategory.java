package com.starlink.backend.lld.practice.composite;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MenuCategory implements MenuItem{
    private String name;
    private ArrayList<MenuItem> subMenu= new ArrayList<>();
    public void add(MenuItem menuItem){
        subMenu.add(menuItem);
    }
    public void remove(MenuItem menuItem){
        subMenu.remove(menuItem);
    }

    public MenuCategory(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
      return  subMenu.stream().mapToInt(s->s.getPrice()).sum();
    }

    @Override
    public String getName() {
        return subMenu.stream().map(s->s.getName()).collect(Collectors.joining(","));
    }
}
