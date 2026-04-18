package com.starlink.backend.lld.practice.facade;

public class SoundSystem {
    private String roomName;

    public SoundSystem(String roomName) {
        this.roomName = roomName;
    }

    public void processSoundSystem(){
        System.out.println("processng soundSystem for room="+roomName);
    }
}
