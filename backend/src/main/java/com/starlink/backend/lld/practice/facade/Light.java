package com.starlink.backend.lld.practice.facade;

public class Light {
    private String roomName;

    public Light(String roomName) {
        this.roomName = roomName;
    }

    public void processLight(){
        System.out.println("processng lights for room="+roomName);
    }
}
