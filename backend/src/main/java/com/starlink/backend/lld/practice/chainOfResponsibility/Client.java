package com.starlink.backend.lld.practice.chainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        FiveHundredRpsHandler fiveHundredRpsHandler= new FiveHundredRpsHandler();
        HundredRpsHandler hundredRpsHandler= new HundredRpsHandler();
        FiftyRpsHandler fiftyRpsHandler= new FiftyRpsHandler();
        fiveHundredRpsHandler.setNextHandler(hundredRpsHandler);
        hundredRpsHandler.setNextHandler(fiftyRpsHandler);
        fiveHundredRpsHandler.handlePayment(3550);
    }
}
