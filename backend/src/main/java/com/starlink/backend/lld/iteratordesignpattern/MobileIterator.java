package com.starlink.backend.lld.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MobileIterator implements  Iterator{
    List<Mobile> mobileStack;
    int curentIdx;
    int maxSize;
    public MobileIterator(Stack<Mobile> mobileStack) {
       this.mobileStack= new ArrayList<>(mobileStack);
        this.maxSize=mobileStack.size();
        this.curentIdx=mobileStack.size()-1;
    }

    @Override
    public boolean hasNext() {
        return curentIdx >= 0;  // ✅ Correct
    }

    @Override
    public Object next() {
        // ✅ Get current, then decrement
        Mobile mobile = mobileStack.get(curentIdx);
        curentIdx -= 1;
        return mobile;
    }
}
