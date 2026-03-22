package com.starlink.backend.lld.splitwise;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {
    
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        // ✅ Business Logic: Validate equal split
        double amountPerUser = totalAmount / splitList.size();
        for (Split split : splitList) {
            if (split.getAmountOwed() != amountPerUser) {
                throw new RuntimeException("Each user should pay exactly: " + amountPerUser);
            }
        }
    }
}