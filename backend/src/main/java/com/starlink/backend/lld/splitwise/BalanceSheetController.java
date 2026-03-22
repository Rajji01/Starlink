package com.starlink.backend.lld.splitwise;

import java.util.List;

public class BalanceSheetController {

    // ✅ Business Logic: Update balances for all users
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {

        // Update payer's balance sheet
        UserExpenseBalanceSheet paidByUserBalanceSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment() + totalExpenseAmount);
        paidByUserBalanceSheet.setTotalYourExpense(paidByUserBalanceSheet.getTotalYourExpense() + totalExpenseAmount);

        for (Split split : splits) {
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserBalanceSheet = userOwe.getUserExpenseBalanceSheet();
            double amountOwe = split.getAmountOwed();

            // If user is the payer, they get money back from others
            if (userOwe.getId().equals(expensePaidBy.getId())) {
                // Payer is also in split (in case of self inclusion)
                paidByUserBalanceSheet.setTotalYouGotBack(
                        paidByUserBalanceSheet.getTotalYouGotBack() + amountOwe
                );
            } else {
                // Update payer's balance sheet (who owes them)
                paidByUserBalanceSheet.setTotalYouGotBack(
                        paidByUserBalanceSheet.getTotalYouGotBack() + amountOwe
                );

                // Get or create balance for the user who owes
                Balance userOweBalance = paidByUserBalanceSheet.getUserVsBalance()
                        .getOrDefault(userOwe.getId(), new Balance());

                userOweBalance.setAmountGetBack(
                        userOweBalance.getAmountGetBack() + amountOwe
                );
                paidByUserBalanceSheet.getUserVsBalance().put(userOwe.getId(), userOweBalance);

                // Update owe user's balance sheet
                oweUserBalanceSheet.setTotalYouOwe(
                        oweUserBalanceSheet.getTotalYouOwe() + amountOwe
                );
                oweUserBalanceSheet.setTotalYourExpense(
                        oweUserBalanceSheet.getTotalYourExpense() + amountOwe
                );

                // Update owe user's balance towards payer
                Balance oweUserBalance = oweUserBalanceSheet.getUserVsBalance()
                        .getOrDefault(expensePaidBy.getId(), new Balance());

                oweUserBalance.setAmountOwe(
                        oweUserBalance.getAmountOwe() + amountOwe
                );
                oweUserBalanceSheet.getUserVsBalance().put(expensePaidBy.getId(), oweUserBalance);
            }
        }
    }
}