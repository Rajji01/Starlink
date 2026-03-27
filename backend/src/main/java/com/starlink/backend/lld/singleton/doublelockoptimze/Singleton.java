package com.starlink.backend.lld.singleton.doublelockoptimze;

public class Singleton {
//    here making Singleton obj removes two issue
//    l1 cache issue
//    reordering of instructions issue
    private static volatile Singleton obj;
    private int members;
    private Singleton(int members) {
        this.members=members;
    }

    public static Singleton getIntstance(int members){

        if(obj==null){
            synchronized (Singleton.class){
                if(obj==null){
                    obj= new Singleton(10);
                }
            }
        }

        return obj;
    }
}
