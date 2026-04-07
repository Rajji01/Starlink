// Client.java
package com.starlink.backend.lld.practice.decorator;

public class Client {
    public static void main(String[] args) {

        BaseProduct baseProduct = new BaseProduct(100);
        System.out.println("Base price: " + baseProduct.getPrice()); // 100

        BaseProduct afterDiscount =
                new FlatDiscount(
                        new FlatDiscount(
                                new PercentageDiscount(baseProduct, 10)
                        )
                );

        System.out.println("After discounts: " + afterDiscount.getPrice());
        // 100 → -10% = 90 → -10 flat = 80 → -10 flat = 70
    }
}