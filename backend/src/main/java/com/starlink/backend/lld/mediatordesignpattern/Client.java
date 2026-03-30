package com.starlink.backend.lld.mediatordesignpattern;

public class Client {
    public static void main(String[] args) {
        Mediator auctionMediator= new AuctionMediator();
        Bidder bidder= new Bidder("rcb",auctionMediator);
        Bidder bidder2= new Bidder("kkr",auctionMediator);
        auctionMediator.addColleague(bidder2);
        auctionMediator.addColleague(bidder);
        bidder.placeBid("rcb bd",19);
    }
}