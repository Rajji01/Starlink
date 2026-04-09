package com.starlink.backend.lld.composite;

// ─── COMPONENT INTERFACE — dono implement karenge ─────────
// Client isi se kaam karta hai — Leaf ya Composite pata nahi
public interface MenuComponent {
    void   display(String indent);  // print karo
    double getPrice();              // price calculate karo
    String getName();
}