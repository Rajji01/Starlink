package com.starlink.backend.lld.command;

// ─── CLIENT ──────────────────────────────────────────────
public class ZomatoCartClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(50));
        System.out.println("  COMMAND PATTERN — Zomato Cart");
        System.out.println("=".repeat(50));

        Cart        cart    = new Cart();
        CartManager manager = new CartManager();

        // ─── Items add karo ───────────────────────────────
        System.out.println("\n=== Items Add Karo ===");
        manager.executeCommand(new AddItemCommand(cart, "Biryani",    280));
        manager.executeCommand(new AddItemCommand(cart, "Butter Naan", 60));
        manager.executeCommand(new AddItemCommand(cart, "Raita",       50));

        System.out.println("\nCart: " + cart.getItems() 
            + " | Total: Rs." + cart.getTotal());

        // ─── Undo — Raita remove ──────────────────────────
        System.out.println("\n=== Undo — Raita Nahi Chahiye ===");
        manager.undo();
        System.out.println("Cart: " + cart.getItems() 
            + " | Total: Rs." + cart.getTotal());

        // ─── Redo — Raita wapas ───────────────────────────
        System.out.println("\n=== Redo — Raita Chahiye Tha ===");
        manager.redo();
        System.out.println("Cart: " + cart.getItems() 
            + " | Total: Rs." + cart.getTotal());

        // ─── Discount apply ───────────────────────────────
        System.out.println("\n=== Discount Apply ===");
        manager.executeCommand(new ApplyDiscountCommand(cart, 50));
        System.out.println("Cart total after discount: Rs." + cart.getTotal());

        // ─── Undo discount ────────────────────────────────
        System.out.println("\n=== Undo Discount ===");
        manager.undo();
        System.out.println("Cart total restored: Rs." + cart.getTotal());

        // ─── Remove item ──────────────────────────────────
        System.out.println("\n=== Remove Item ===");
        manager.executeCommand(new RemoveItemCommand(cart, "Butter Naan", 60));
        System.out.println("Cart: " + cart.getItems());

        // ─── Undo remove ──────────────────────────────────
        System.out.println("\n=== Undo Remove ===");
        manager.undo();
        System.out.println("Cart: " + cart.getItems());
    }
}