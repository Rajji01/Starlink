package com.starlink.backend.lld.practice.template;

public class Client {
    public static void main(String[] args) {
        OrderProcessor zomato= new ZomatoOrderProcessor("101");
        OrderProcessor swiggy= new SwiggyOrderProcess("102");
        zomato.processOrder();
        swiggy.processOrder();
    }
}
