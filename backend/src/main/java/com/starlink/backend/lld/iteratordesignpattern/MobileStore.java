package com.starlink.backend.lld.iteratordesignpattern;

import java.util.List;
import java.util.Stack;

public class MobileStore implements Aggregator{
    Stack<Mobile> mobileList;

    public MobileStore(Stack<Mobile> mobileList) {
        this.mobileList = mobileList;
    }

    @Override
    public Iterator createIterator() {
        return new MobileIterator(mobileList);
    }
}
