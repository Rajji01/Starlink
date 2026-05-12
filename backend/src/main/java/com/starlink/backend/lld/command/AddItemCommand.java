package com.starlink.backend.lld.command;// ─── CONCRETE COMMANDS ────────────────────────────────────

// Command 1: Item Add
public class AddItemCommand implements Command {

    private final Cart   cart;
    private final String item;
    private final double price;

    public AddItemCommand(Cart cart, String item, double price) {
        this.cart  = cart;
        this.item  = item;
        this.price = price;
    }

    @Override
    public void execute() {
        cart.addItem(item, price);      // karo
    }

    @Override
    public void undo() {
        cart.removeItem(item, price);   // reverse — remove karo
    }
}