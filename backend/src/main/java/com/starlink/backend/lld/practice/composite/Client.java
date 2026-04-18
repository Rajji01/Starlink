package com.starlink.backend.lld.practice.composite;

public class Client {
    public static void main(String[] args) {
        MenuCategory snacksMenu= new MenuCategory("snacksMenu");
        MenuItem samosa= new MenuComponent("samosa",120);
        MenuItem kachori= new MenuComponent("kachori",129);
        snacksMenu.add(samosa);
        snacksMenu.add(kachori);
        MenuCategory dinner= new MenuCategory("dineer");
        MenuItem daalMakhani= new MenuComponent("daalMakhain",1200);
        MenuItem rayta= new MenuComponent("rayta",1800);
        dinner.add(daalMakhani);
        dinner.add(rayta);
        System.out.println(snacksMenu.getName()+" "+snacksMenu.getPrice());
        System.out.println(dinner.getName()+" "+snacksMenu.getPrice());
    }
}
