package com.starlink.backend.lld.singleton.lazy;

import com.starlink.backend.lld.singleton.eager.Singleton;

public class Client {
    public static void main(String[] args) {
        String s= Singleton.getIntstance();
        System.out.println(s);
    }
}
