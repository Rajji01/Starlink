package com.starlink.backend.lld.practice.facade;

public class Projector {
    private String roomName;

    public Projector(String roomName) {
        this.roomName = roomName;
    }

    public void processLight(){
        System.out.println("processng Projector for room="+roomName);
    }
}
