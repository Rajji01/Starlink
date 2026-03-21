package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public interface State {
    public  void pressInsertCashButoon(VendingMachine vendingMachine);
    public  void insertCoin(VendingMachine vendingMachine,Coin coin);
    public  void selectProdButton(VendingMachine vendingMachine);
    public  void chooseProdButton(VendingMachine vendingMachine,int prdCode);
    public Item dispenseItem(VendingMachine vendingMachine,int prdCd);
    public int getChange(int retunChangeMoney);
    public List<Coin> refundFullMoney(VendingMachine vendingMachine);
    public void updateInventory(VendingMachine vendingMachine);
}
