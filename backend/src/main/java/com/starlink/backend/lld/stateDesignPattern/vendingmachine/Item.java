package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

public class Item {
    int price;
    ItemType itemType;
    int count=0;

    public Item(int price, ItemType itemType, int count) {
        this.price = price;
        this.itemType = itemType;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
