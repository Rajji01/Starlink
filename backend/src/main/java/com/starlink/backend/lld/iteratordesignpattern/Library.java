package com.starlink.backend.lld.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Library implements Aggregator{
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}
