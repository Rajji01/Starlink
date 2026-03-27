package com.starlink.backend.lld.singleton.doublelockoptimze;

public class Client {
    public static void main(String[] args) {
        Singleton s= Singleton.getIntstance(10);
        Singleton s1= Singleton.getIntstance(10);
        Singleton s2= Singleton.getIntstance(10);
        System.out.println((s1==s2)&&(s1==s));
    }
}
