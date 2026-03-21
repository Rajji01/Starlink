package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.List;

public class SelectionState implements State{
    @Override
    public void pressInsertCashButoon(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine,Coin coin) {

    }

    @Override
    public void selectProdButton(VendingMachine vendingMachinen) {

    }

    @Override
    public void chooseProdButton(VendingMachine vendingMachine, int prdCode) {
        System.out.println("inside selection State insert coins nowbaya");
        ItemType prod=prdCode==1?ItemType.COKE:prdCode==2?ItemType.PEPSI:ItemType.SNICKERS;
        int price = vendingMachine.getInventory().getSelfs().stream()
                .filter(self -> self.getItem().getItemType() == prod)
                .mapToInt(self -> self.getItem().getPrice())  // ✅ mapToInt for sum
                .sum();  // ✅ Sum all prices
        int totalCoinsValue=0;
        System.out.println("inside selection prod="+prod+" price="+price);
        for(Coin coin: vendingMachine.getCoinsList()){
            if(Coin.ONE==coin){
                totalCoinsValue+=1;
            }
            else if(Coin.TENS==coin){
                totalCoinsValue+=10;
            }
        }
        System.out.println("inside selection state tot="+totalCoinsValue);
        if(totalCoinsValue<price){
            refundFullMoney(vendingMachine);
            vendingMachine.setState(new IdleState());

        }
        else{
            if(totalCoinsValue>=price){
                getChange(totalCoinsValue-price);
            }
            vendingMachine.setState(new DispenseState(vendingMachine,prdCode));

        }
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine,int prdCd) {
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
