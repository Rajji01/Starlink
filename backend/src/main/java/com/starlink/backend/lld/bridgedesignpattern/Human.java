package com.starlink.backend.lld.bridgedesignpattern;

public class Human extends LivingThings{
    public Human(HumanBreathe breathe) {
        super(breathe);
    }

    @Override
    public void breathe() {
        breathe.doBreathe();
    }
}
