package com.starlink.backend.lld.iteratordesignpattern;

import java.util.List;

public class BookIterator implements  Iterator{
    List<Book> books;
    int currentPos=-1;
    int maxSize;
    public BookIterator(List<Book> books) {
        this.books = books;
        this.maxSize=books.size()-1;
    }

    @Override
    public boolean hasNext() {
        if(currentPos<maxSize){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        currentPos+=1;
        return books.get(currentPos);
    }
}
