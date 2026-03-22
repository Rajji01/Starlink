package com.starlink.backend.lld.splitwise;

import java.util.List;

public class ExpenseController {
    private BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    // ✅ Business Logic: Create expense with validation
    public Expense createExpense(int expenseId, String description, double amount,
                                 List<Split> splitDetails, ExpenseSplitType splitType,
                                 User paidByUser) {

        // Get split strategy
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);

        if (expenseSplit == null) {
            throw new RuntimeException("Invalid split type!");
        }

        // Validate split request
        expenseSplit.validateSplitRequest(splitDetails, amount);

        // Create expense
        Expense expense = new Expense(expenseId, paidByUser, amount, splitDetails, description);

        // Update balance sheets
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, amount);

        return expense;
    }
}