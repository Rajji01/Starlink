package com.starlink.backend.lld.mementodesignpattern.zomato;

import java.util.ArrayDeque;
import java.util.Deque;

// Client
public class ZomatoClient {
    public static void main(String[] args) {

        ZomatoCart cart    = new ZomatoCart();
        Deque<CartSnapshot> history = new ArrayDeque<>();

        history.push(cart.save()); // empty state save

        cart.addItem("Butter Chicken", 350);
        history.push(cart.save());

        cart.addItem("Naan x2", 80);
        history.push(cart.save());

        cart.addItem("Raita", 50);
        // save nahi kiya — undo karo

        System.out.println("\n--- Undo last action ---");
        history.pop(); // current state pop
        cart.restore(history.peek()); // pichla state restore
    }
}