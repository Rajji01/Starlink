package com.starlink.backend.lld.command;

// Command 3: Discount Apply
public class ApplyDiscountCommand implements Command {

    private final Cart   cart;
    private final double discount;

    public ApplyDiscountCommand(Cart cart, double discount) {
        this.cart     = cart;
        this.discount = discount;
    }

    @Override
    public void execute() {
        cart.applyDiscount(discount);   // karo
    }

    @Override
    public void undo() {
        cart.removeDiscount(discount);  // reverse
    }
}