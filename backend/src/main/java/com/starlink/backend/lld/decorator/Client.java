package com.starlink.backend.lld.decorator;

public class Client {
    public static void main(String[] args) {
        BasePizza pizza1= new Margarita();
        BasePizza extraExtraCheesMargarita=new ExtraSpice(new ExtraCheese( new ExtraCheese(pizza1)));
        System.out.println(extraExtraCheesMargarita.cost());
    }
}
