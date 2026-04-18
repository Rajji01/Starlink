package com.starlink.backend.lld.practice.observer;

public class Client {
    public static void main(String[] args) {
        Stocks stocksObserver= new Stocks("apple",120);
        StocksObservable emailObserver1= new EmailNotifier("rajji01");
        StocksObservable msgObserver1 =new MsgNotifier("rajat");
        stocksObserver.addObservable(emailObserver1);
        stocksObserver.addObservable(msgObserver1);
        stocksObserver.priceChange(10,true);
    }
}
