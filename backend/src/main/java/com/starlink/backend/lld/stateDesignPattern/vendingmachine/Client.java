package com.starlink.backend.lld.stateDesignPattern.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        VendingMachine vendingMachine= new VendingMachine();
        populateVendinMachine(vendingMachine);
        State iddleState=vendingMachine.getState();
        iddleState.pressInsertCashButoon(vendingMachine);

        State hasMoneyState=vendingMachine.getState();
        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
//        hasMoneyState.insertCoin(vendingMachine,Coin.ONE);
        hasMoneyState.selectProdButton(vendingMachine);
        State selection= vendingMachine.getState();
        selection.chooseProdButton(vendingMachine,1);



    }
    public static void populateVendinMachine(VendingMachine vendingMachine){
        Item coke= new Item(5,ItemType.COKE,5);
        Item pepsi= new Item(15,ItemType.PEPSI,5);
        Item snickers = new Item(10,ItemType.SNICKERS,5);
        ItemShelf shelf1= new ItemShelf(coke,1);
        ItemShelf shelf2= new ItemShelf(pepsi,2);
        ItemShelf shelf3= new ItemShelf(snickers,3);
        List<ItemShelf> itemShelfList= new ArrayList<>();
        itemShelfList.add(shelf1);
        itemShelfList.add(shelf2);
        itemShelfList.add(shelf3);
        Inventory inventory= new Inventory(itemShelfList,3);
        vendingMachine.setInventory(inventory);
    }
}
