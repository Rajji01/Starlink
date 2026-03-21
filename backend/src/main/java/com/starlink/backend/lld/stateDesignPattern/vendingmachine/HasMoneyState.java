package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public class HasMoneyState implements State{
    @Override
    public void pressInsertCashButoon(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine,Coin coin) {
        System.out.println("inside hasMoney State insert coins nowbaya");
    vendingMachine.getCoinsList().add(coin);
    }

    @Override
    public void selectProdButton(VendingMachine vendingMachine) {
        System.out.println("inside hasMoney now selecting pro");
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void chooseProdButton(VendingMachine vendingMachine, int prdCode) {

    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine,int prdcd) {
        return null;
    }

    @Override
    public int getChange(int retunChangeMoney) {
        return 0;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {

    }
}
