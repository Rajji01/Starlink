package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public class IdleState implements State{
    @Override
    public void pressInsertCashButoon(VendingMachine vendingMachine) {
        System.out.println("inside mvng from idle to hasMoney");
    vendingMachine.setState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void selectProdButton(VendingMachine vendingMachine) {

    }

    @Override
    public void chooseProdButton(VendingMachine vendingMachine, int prdCode) {

    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int prdCd) {
        return null;
    }

    @Override
    public int getChange(int retunChangeMoney) {
        return 0;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {

    }


}
