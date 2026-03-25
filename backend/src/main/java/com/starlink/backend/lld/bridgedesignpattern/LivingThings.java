package com.starlink.backend.lld.bridgedesignpattern;

public abstract class LivingThings {
    Breathe breathe;
    public abstract void breathe();

    public LivingThings(Breathe breathe) {
        this.breathe = breathe;
    }
}
