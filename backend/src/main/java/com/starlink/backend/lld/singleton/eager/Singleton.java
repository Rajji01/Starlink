package com.starlink.backend.lld.singleton.eager;

public class Singleton {
    private static String obj= new String("rajat");

    private Singleton() {
    }

    public static String getIntstance(){
        return obj;
    }
}
