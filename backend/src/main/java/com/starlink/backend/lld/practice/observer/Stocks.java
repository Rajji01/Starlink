package com.starlink.backend.lld.practice.observer;

import java.util.ArrayList;
import java.util.List;

public class Stocks implements StocksObserver{
    private String stockName;
    private int price;
    private List<StocksObservable> accounts= new ArrayList<>();
    public void addObservable(StocksObservable stocksObservable){
        accounts.add(stocksObservable);
    }
    public void removeObservable(StocksObservable stocksObservable){
        accounts.remove(stocksObservable);
    }
    public Stocks(String stockName,int price) {
        this.stockName = stockName;
        this.price=price;
    }

    @Override
    public void update() {
        accounts.stream().forEach(s->s.notifyClient());
    }
    public void priceChange(int price,boolean negative){
        if(negative){
            this.price-=price;
        }
        else{
            this.price+=price;
        }
        update();
    }

}
