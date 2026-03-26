package com.starlink.backend.lld.singleton.doublelockoptimze;

public class Singleton {
    private static String obj;

    private Singleton() {
    }

    public static String getIntstance(){

        if(obj==null){
            synchronized (String.class){
                if(obj==null){
                    obj= new String("rajat");
                }
            }
        }

        return obj;
    }
}
