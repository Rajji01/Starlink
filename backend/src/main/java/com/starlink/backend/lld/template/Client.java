package com.starlink.backend.lld.template;

public class Client {
    public static void main(String[] args) {
        OrderProcessor zomatoOrderProcessor= new ZomatoOrderProcessor();
        OrderProcessor swiggyOrderProcessor= new SwiggyOrderProcessor();
        zomatoOrderProcessor.processOrder("1234");
        swiggyOrderProcessor.processOrder("1227");
    }
}
