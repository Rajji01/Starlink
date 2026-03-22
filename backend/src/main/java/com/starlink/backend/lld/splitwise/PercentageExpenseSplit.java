package com.starlink.backend.lld.splitwise;

import java.util.List;


import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        // ✅ Validate percentages sum to 100
        double totalPercentage = 0;
        for (Split split : splitList) {
            totalPercentage += split.getAmountOwed();
        }

        if (Math.abs(totalPercentage - 100.0) > 0.01) {  // Allow small floating point error
            throw new RuntimeException("Percentages must add up to 100%! Current: " + totalPercentage);
        }

        // ✅ Convert percentage to actual amount
        for (Split split : splitList) {
            double percentage = split.getAmountOwed();
            double amount = (percentage * totalAmount) / 100;
            split.setAmountOwed(amount);
        }
    }
}