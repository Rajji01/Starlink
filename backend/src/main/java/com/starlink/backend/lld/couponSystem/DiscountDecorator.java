package com.starlink.backend.lld.couponSystem;

// Abstract Decorator — Product extend karta hai
// AUR ek Product wrap karta hai
// Yahi Decorator pattern ka core hai
public abstract class DiscountDecorator extends Product {

    // Wrapped product — iska price base hai
    protected Product product;

    // Decorator ko sirf wrapped product chahiye
    // prodId/prodName/price wahan se aayenge
    public DiscountDecorator(Product product) {
        super(
            product.getProdId(),
            product.getProdName(),
            product.getPrice()   // current price — already discounted ho sakta hai
        );
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice();  // default — wrapped product ka price
    }

    @Override
    public String getDescription() {
        return product.getDescription();  // chain propagate karo
    }
}