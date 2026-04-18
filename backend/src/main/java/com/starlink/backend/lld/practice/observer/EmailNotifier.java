package com.starlink.backend.lld.practice.observer;

public class EmailNotifier implements StocksObservable{
private String userName;

    public EmailNotifier(String userName) {
        this.userName = userName;
    }

    @Override
    public void notifyClient() {
        //fetch eamil from usenamr
        String email="email";
        //mail sent
        System.out.println("mail sent to user"+userName);
    }
}
