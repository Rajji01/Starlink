package com.starlink.backend.lld.mediatordesignpattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator{
    List<Colleague> biddersList= new ArrayList<>();
    @Override
    public void sendMsg(Colleague colleague,String bid) {
    for(Colleague cl:biddersList){
        System.out.println(cl.getName());
        if(cl!=colleague){
            System.out.println("notified team="+cl.getName());
        }
    }
    }

    @Override
    public void addColleague(Colleague colleague) {
        biddersList.add(colleague);
    }
}
