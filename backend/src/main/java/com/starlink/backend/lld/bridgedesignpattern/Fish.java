package com.starlink.backend.lld.bridgedesignpattern;

public class Fish extends LivingThings{
    public Fish(FishBreathe breathe) {
        super(breathe);
    }

    @Override
    public void breathe() {
        breathe.doBreathe();
    }
}
