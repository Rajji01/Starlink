package com.starlink.backend.lld.singleton.lazy;

public class Singleton {
    private static String obj;

    private Singleton() {
    }

    public static String getIntstance(){
        if(obj==null) {
            obj = new String("rajat");
        }
        return obj;
    }
}
