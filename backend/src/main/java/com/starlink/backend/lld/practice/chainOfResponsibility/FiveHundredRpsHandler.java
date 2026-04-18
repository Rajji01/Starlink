package com.starlink.backend.lld.practice.chainOfResponsibility;

public class FiveHundredRpsHandler extends CashHandler{

    @Override
    public void handlePayment(int amount) {
        if(amount>=500){
            System.out.println("500 rps notes= * "+(amount/500));
            amount=amount-(500*(amount/500));
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
