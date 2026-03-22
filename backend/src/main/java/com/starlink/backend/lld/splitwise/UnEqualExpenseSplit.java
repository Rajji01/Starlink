package com.starlink.backend.lld.splitwise;

import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplit {
    
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        // ✅ Business Logic: Validate unequal split
        double totalSplitAmount = splitList.stream()
            .mapToDouble(Split::getAmountOwed)
            .sum();
            
        if (totalSplitAmount != totalAmount) {
            throw new RuntimeException("Split amounts don't add up to total amount!");
        }
    }
}