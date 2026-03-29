package com.starlink.backend.lld.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("sc1","scinece"));
        books.add(new Book("sc2","scinece"));
        books.add(new Book("sc3","scinece"));
        Library library= new Library(books);
        Iterator iterator = library.createIterator();
        while(iterator.hasNext()){
            Book book=(Book) iterator.next();
            System.out.println(book.getName());
        }
        Stack<Mobile>stack= new Stack<>();
        stack.push(new Mobile("moto edge 20","jsdkfja"));
        stack.push(new Mobile("moto edge 30","js1234fja"));
        stack.push(new Mobile("moto edge 20 Fusion","j111s1234fja"));
        MobileStore mobileStore= new MobileStore(stack);
        Iterator iterator1=mobileStore.createIterator();
        while(iterator1.hasNext()){
            Mobile mobile=(Mobile) iterator1.next();
            System.out.println(mobile.getSetName());
        }
    }
}
