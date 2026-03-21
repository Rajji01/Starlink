package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

public class ItemShelf {
    Item item;
    int shelfNumber;
    boolean hasItem;
    public ItemShelf(Item item, int shelfNumber) {
        this.item = item;
        this.shelfNumber = shelfNumber;
    }

    public ItemShelf(Item item, int shelfNumber, boolean hasItem) {
        this.item = item;
        this.shelfNumber = shelfNumber;
        this.hasItem = hasItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
}
