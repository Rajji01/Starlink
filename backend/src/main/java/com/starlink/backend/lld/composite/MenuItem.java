package com.starlink.backend.lld.composite;

// ─── LEAF — Individual item — no children ────────────────
public class MenuItem implements MenuComponent {

    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name        = name;
        this.price       = price;
        this.description = description;
    }

    @Override
    public void display(String indent) {
        // Leaf — sirf apna data print karo
        System.out.println(indent + "🍽  " + name
            + " — Rs." + price + " (" + description + ")");
    }

    @Override
    public double getPrice() {
        return price; // apna price return karo
    }

    @Override
    public String getName() { return name; }
}