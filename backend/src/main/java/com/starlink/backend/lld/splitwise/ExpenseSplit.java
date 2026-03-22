package com.starlink.backend.lld.splitwise;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
