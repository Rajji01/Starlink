package com.starlink.backend.lld.practice.observer;

public class MsgNotifier implements StocksObservable{
    private String username;

    public MsgNotifier(String username) {
        this.username = username;
    }

    @Override
    public void notifyClient() {
        // get mobile number from username
        String mobileNumber="jdlkadsjf";
        //msg sent
        System.out.println(" msg sent to user"+username);
    }
}
