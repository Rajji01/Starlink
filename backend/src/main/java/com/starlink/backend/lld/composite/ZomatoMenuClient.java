package com.starlink.backend.lld.composite;

// ─── CLIENT ──────────────────────────────────────────────
public class ZomatoMenuClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(55));
        System.out.println("  COMPOSITE PATTERN — Zomato Menu System");
        System.out.println("=".repeat(55));

        // ─── Leaf items banao ──────────────────────────────
        MenuItem tikka   = new MenuItem("Chicken Tikka",   180, "Grilled chicken");
        MenuItem samosa  = new MenuItem("Veg Samosa",       60, "Crispy snack");
        MenuItem kebab   = new MenuItem("Seekh Kebab",     220, "Minced meat");

        MenuItem butter  = new MenuItem("Butter Chicken",  320, "Creamy curry");
        MenuItem biryani = new MenuItem("Chicken Biryani", 280, "Aromatic rice");
        MenuItem paneer  = new MenuItem("Paneer Makhani",  260, "Cottage cheese");

        MenuItem gulab   = new MenuItem("Gulab Jamun",      80, "Sweet dessert");
        MenuItem kulfi   = new MenuItem("Mango Kulfi",      90, "Indian ice cream");

        // ─── Composite categories banao ───────────────────
        MenuCategory starters  = new MenuCategory("STARTERS");
        starters.add(tikka);
        starters.add(samosa);
        starters.add(kebab);

        MenuCategory mainCourse = new MenuCategory("MAIN COURSE");
        mainCourse.add(butter);
        mainCourse.add(biryani);
        mainCourse.add(paneer);

        MenuCategory desserts = new MenuCategory("DESSERTS");
        desserts.add(gulab);
        desserts.add(kulfi);

        // ─── Root menu — sab categories add karo ──────────
        MenuCategory fullMenu = new MenuCategory("ZOMATO RESTAURANT MENU");
        fullMenu.add(starters);   // Composite add kiya
        fullMenu.add(mainCourse); // Composite add kiya
        fullMenu.add(desserts);   // Composite add kiya

        // ─── Client ka kaam — same call, kuch pata nahi ───
        System.out.println("\n--- Full Menu ---");
        fullMenu.display(""); // ek call — poora tree print!

        System.out.println("\n--- Starters Only ---");
        starters.display(""); // sirf starters

        System.out.println("\n--- Single Item ---");
        tikka.display("");    // sirf ek item — same method!

        // ─── Price calculations ───────────────────────────
        System.out.println("\n--- Price Calculations ---");
        System.out.println("Tikka price:      Rs." + tikka.getPrice());
        System.out.println("Starters total:   Rs." + starters.getPrice());
        System.out.println("Full menu total:  Rs." + fullMenu.getPrice());

        // ─── Dynamic add/remove ───────────────────────────
        System.out.println("\n--- Naya Item Add Karo ---");
        MenuItem newItem = new MenuItem("Chicken Wings", 199, "Crispy wings");
        starters.add(newItem);
        System.out.println("Starters after add: Rs." + starters.getPrice());

        // ─── Nested Composite ─────────────────────────────
        System.out.println("\n--- Nested — Combo Meals ---");
        MenuCategory comboMeals = new MenuCategory("COMBO MEALS");

        // Combo = starters ka subset + main
        MenuCategory lunchCombo = new MenuCategory("Lunch Combo");
        lunchCombo.add(new MenuItem("Naan x2",     40, "Indian bread"));
        lunchCombo.add(new MenuItem("Dal Makhani", 180, "Lentil curry"));
        lunchCombo.add(new MenuItem("Raita",        50, "Yogurt dip"));

        MenuCategory dinnerCombo = new MenuCategory("Dinner Combo");
        dinnerCombo.add(new MenuItem("Tandoori Roti x3", 45, "Baked bread"));
        dinnerCombo.add(new MenuItem("Paneer Butter",    280, "Cottage cheese"));

        comboMeals.add(lunchCombo);   // Composite inside Composite!
        comboMeals.add(dinnerCombo);

        comboMeals.display(""); // poora nested tree print
        System.out.println("Combo meals total: Rs." + comboMeals.getPrice());
    }
}