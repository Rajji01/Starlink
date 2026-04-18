package com.starlink.backend.lld.practice.chainOfResponsibility;

public class FiftyRpsHandler extends CashHandler{
    @Override
    public void handlePayment(int amount) {
        if(amount>=50){
            System.out.println("50 rps notes= * "+(amount/50));
            amount=amount-(50*(amount/50));
            if(amount ==0){
                System.out.println("amount handled");
                return;
            }
            if(nextHandler!=null){
                nextHandler.handlePayment(amount);
            }
            else{
                System.out.println("can not proceed ahead with given amount");
            }
        }
        else if(nextHandler!=null){
            nextHandler.handlePayment(amount);
        }
        else{
            System.out.println("can not proceed ahead with given amount");
        }
    }

}
