package com.starlink.backend.lld.practice.facade;

public class FacadeHomeTheater {
    Light light;
    Projector projector;
    SoundSystem soundSystem;

    public FacadeHomeTheater(String roomName) {
        this.light = new Light(roomName);
        this.projector = new Projector(roomName);
        this.soundSystem = new SoundSystem(roomName);
    }
    public void makeHomeTheater(){
        light.processLight();
        soundSystem.processSoundSystem();
        projector.processLight();
    }
}
