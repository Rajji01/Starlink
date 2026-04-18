package com.starlink.backend.lld.practice.composite;

public class MenuComponent implements MenuItem{
    private String name;
    private int price;
    public MenuComponent(String name,int price) {
        this.name = name;
        this.price=price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
