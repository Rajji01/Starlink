package com.starlink.backend.lld.command;

// Command 2: Item Remove
public class RemoveItemCommand implements Command {

    private final Cart   cart;
    private final String item;
    private final double price;

    public RemoveItemCommand(Cart cart, String item, double price) {
        this.cart  = cart;
        this.item  = item;
        this.price = price;
    }

    @Override
    public void execute() {
        cart.removeItem(item, price);   // karo
    }

    @Override
    public void undo() {
        cart.addItem(item, price);      // reverse — wapas add karo
    }
}