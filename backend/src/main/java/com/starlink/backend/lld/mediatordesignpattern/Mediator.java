package com.starlink.backend.lld.mediatordesignpattern;

public interface Mediator {
    public void sendMsg(Colleague colleague,String msg);
    public void addColleague(Colleague colleague);
}
