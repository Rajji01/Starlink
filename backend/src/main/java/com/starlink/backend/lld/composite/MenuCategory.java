package com.starlink.backend.lld.composite;

import java.util.ArrayList;
import java.util.List;

// ─── COMPOSITE — Container — children ho sakte hain ──────
public class MenuCategory implements MenuComponent {

    private final String               name;
    private final List<MenuComponent> children = new ArrayList<>();
    // ✅ children = MenuComponent — Leaf bhi, Composite bhi!

    public MenuCategory(String name) {
        this.name = name;
    }

    // Child add karo — Leaf ya Composite kuch bhi
    public void add(MenuComponent component) {
        children.add(component);
    }

    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        // Apna naam print karo
        System.out.println(indent + "📁 " + name
            + " (Total: Rs." + String.format("%.0f", getPrice()) + ")");

        // ✅ Recursion — har child ko display() call karo
        // Child Leaf hai toh apna print karega
        // Child Composite hai toh apne children bhi print karega
        for (MenuComponent child : children) {
            child.display(indent + "   "); // indent badhao
        }
    }

    @Override
    public double getPrice() {
        // ✅ Recursion — sab children ka price sum karo
        return children.stream()
            .mapToDouble(MenuComponent::getPrice)
            .sum();
    }

    @Override
    public String getName() { return name; }
}