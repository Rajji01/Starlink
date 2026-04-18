package com.starlink.backend.lld.practice.chainOfResponsibility;

public class HundredRpsHandler extends CashHandler{
    @Override
    public void handlePayment(int amount) {
        if(amount>=100){
            System.out.println("100 rps notes= * "+(amount/100));
            amount=amount-(100*(amount/100));
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
