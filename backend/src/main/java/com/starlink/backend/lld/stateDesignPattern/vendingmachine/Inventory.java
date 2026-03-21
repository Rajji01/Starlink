package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public class Inventory {
    List<ItemShelf> selfs;
    int shelfNumber;

    public Inventory(List<ItemShelf> selfs, int shelfNumber) {
        this.selfs = selfs;
        this.shelfNumber = shelfNumber;
    }

    public Inventory() {
    }

    public List<ItemShelf> getSelfs() {
        return selfs;
    }

    public void setSelfs(List<ItemShelf> selfs) {
        this.selfs = selfs;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }
}
