package com.starlink.backend.lld.bridgedesignpattern;

public class Client {
    public static void main(String[] args) {
        LivingThings livingThingsHuman= new Human(new HumanBreathe());
        livingThingsHuman.breathe();
        LivingThings livingThingsFish= new Fish(new FishBreathe());
        livingThingsFish.breathe();
    }
}
