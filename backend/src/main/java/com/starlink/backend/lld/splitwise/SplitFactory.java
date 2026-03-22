package com.starlink.backend.lld.splitwise;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType expenseSplitType) {
        switch(expenseSplitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnEqualExpenseSplit();
            case PERCENTAGE:  // ✅ Fixed: PEHLE PERCENTAGE THA
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}