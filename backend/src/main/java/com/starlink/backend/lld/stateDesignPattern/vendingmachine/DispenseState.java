package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public class DispenseState implements  State{
    public DispenseState(VendingMachine vendingMachine,int prdCd) {
        dispenseItem(vendingMachine,prdCd);
    }

    @Override
    public void pressInsertCashButoon(VendingMachine vendingMachine) {

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
    public Item dispenseItem(VendingMachine vendingMachine,int prdCd) {
System.out.println("in dispense staet");
        ItemType prod=prdCd==1?ItemType.COKE:prdCd==2?ItemType.PEPSI:ItemType.SNICKERS;
        ItemShelf itemShelf=vendingMachine.getInventory().getSelfs().stream()
                        .filter(itemShelf1 -> itemShelf1.getItem().getItemType()==prod)
                .findFirst().get();
        if(itemShelf.getItem().getCount()>0){
            itemShelf.getItem().setCount(itemShelf.getItem().getCount()-1);
            System.out.println("dipensing prd="+itemShelf.getItem().getItemType());
        }
        else{
            System.out.println("item not in stock");
        }
        vendingMachine.setState(new IdleState());

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
