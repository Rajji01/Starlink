package com.starlink.backend.lld.iteratordesignpattern;

public class Book {
    String name;
    String gener;

    public Book(String name, String gener) {
        this.name = name;
        this.gener = gener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }
}
