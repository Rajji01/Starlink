package com.starlink.backend.lld.couponSystem;

public abstract class Product {

    private int prodId;
    private String prodName;
    protected int price;  // protected — decorators access kar sakein

    public Product(int prodId, String prodName, int price) {
        this.prodId   = prodId;
        this.prodName = prodName;
        this.price    = price;
    }

    public int    getProdId()   { return prodId; }
    public String getProdName() { return prodName; }
    public int    getPrice()    { return price; }  // concrete bhi override kar sakta hai

    // Description chain ke liye — debug mein helpful
    public abstract String getDescription();
}