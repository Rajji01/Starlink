package com.starlink.backend.lld.practice.iterator;

import java.util.ArrayList;
import java.util.List;

// ─── CLIENT ──────────────────────────────────────────────
public class ZomatoMenuClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(55));
        System.out.println("  ITERATOR PATTERN — Zomato Menu System");
        System.out.println("=".repeat(55));

        BreakFastMenu breakfastMenu = new BreakFastMenu();
        LunchMenu     lunchMenu     = new LunchMenu();
        Waitress      waitress      = new Waitress();

        // ─── Same printMenu() — alag collections ─────────
        System.out.println("\n=== Breakfast Menu (ArrayList) ===");
        waitress.printMenu(breakfastMenu.createIterator());

        System.out.println("\n=== Lunch Menu (Array) ===");
        waitress.printMenu(lunchMenu.createIterator());

        // ─── Price filter ─────────────────────────────────
        System.out.println("\n=== Breakfast Items under Rs.55 ===");
        waitress.printMenuWithPrice(breakfastMenu.createIterator(), 55);

        // ─── Filtered Iterator ────────────────────────────
        System.out.println("\n=== South Indian Items Only ===");
        List<MenuItem> allItems = new ArrayList<>();
        // Combine both menus
        MenuIterator it = breakfastMenu.createIterator();
        while (it.hasNext()) allItems.add(it.next());

//        waitress.printMenu(
//            new FilteredMenuIterator(allItems, "South Indian")
//        );
    }
}