package com.starlink.backend.lld.mediatordesignpattern;

public class Bidder implements Colleague{
    String name;
    int bid;
    Mediator auctionMediator;

    public Bidder(String name, int bid) {
        this.name = name;
        this.bid = bid;
    }

    public Bidder(String name,  Mediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
    }

    @Override
    public void placeBid(String msg,int bid) {
        auctionMediator.sendMsg(this,String.valueOf(bid));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Mediator getAuctionMediator() {
        return auctionMediator;
    }

    public void setAuctionMediator(Mediator auctionMediator) {
        this.auctionMediator = auctionMediator;
    }
}
