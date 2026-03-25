package com.starlink.backend.lld.bridgedesignpattern;

public class FishBreathe implements  Breathe{
    @Override
    public void doBreathe() {
        System.out.println("breathe through gills");
    }
}
