package com.starlink.backend.lld.singleton.eager;

public class Client {
    public static void main(String[] args) {
        String s= Singleton.getIntstance();
        System.out.println(s);
    }
}
