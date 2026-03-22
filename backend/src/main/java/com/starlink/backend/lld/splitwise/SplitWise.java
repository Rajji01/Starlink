package com.starlink.backend.lld.splitwise;

import java.util.*;

public class SplitWise {
    UserController userController;
    GroupController groupController;
    ExpenseController expenseController;

    public SplitWise() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.expenseController = new ExpenseController();
    }

    // ✅ Helper: Create equal splits
    private List<Split> createEqualSplits(List<User> users, double totalAmount) {
        double amountPerUser = totalAmount / users.size();
        List<Split> splits = new ArrayList<>();
        for (User user : users) {
            splits.add(new Split(user, amountPerUser));
        }
        return splits;
    }

    // ✅ Helper: Create percentage splits
    private List<Split> createPercentageSplits(List<User> users, List<Double> percentages, double totalAmount) {
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            // Store percentage initially, will be converted to amount in validate
            splits.add(new Split(users.get(i), percentages.get(i)));
        }
        return splits;
    }

    // ✅ Business Logic: Initialize demo data
    public void initializeDemo() {
        // Create users
        User user1 = userController.addUser("1", "Raj");
        User user2 = userController.addUser("2", "Simran");
        User user3 = userController.addUser("3", "Amit");
        User user4 = userController.addUser("4", "Priya");

        List<User> allUsers = Arrays.asList(user1, user2, user3, user4);

        // Create group
        Group tripGroup = groupController.createGroup("G1", "Goa Trip", allUsers);

        // Expense 1: Dinner - Equal split
        List<Split> dinnerSplits = createEqualSplits(allUsers, 4000);
        Expense dinner = expenseController.createExpense(1, "Dinner at Sea View", 4000,
                dinnerSplits, ExpenseSplitType.EQUAL, user1);
        tripGroup.getExpenseList().add(dinner);

        // Expense 2: Cab - Unequal split
        List<Split> cabSplits = Arrays.asList(
                new Split(user1, 500),
                new Split(user2, 500),
                new Split(user3, 300),
                new Split(user4, 200)
        );
        Expense cab = expenseController.createExpense(2, "Taxi to Beach", 1500,
                cabSplits, ExpenseSplitType.UNEQUAL, user2);
        tripGroup.getExpenseList().add(cab);

        // Expense 3: Activity - Percentage split
        List<Double> percentages = Arrays.asList(40.0, 30.0, 20.0, 10.0);
        List<Split> activitySplits = createPercentageSplits(allUsers, percentages, 5000);
        Expense activity = expenseController.createExpense(3, "Water Sports", 5000,
                activitySplits, ExpenseSplitType.PERCENTAGE, user3);
        tripGroup.getExpenseList().add(activity);

        System.out.println("✅ Demo data initialized successfully!");
        System.out.println("Expenses added:");
        System.out.println("  1. Dinner: ₹4000 (Equal split - ₹1000 each)");
        System.out.println("  2. Taxi: ₹1500 (Unequal split - Raj:500, Simran:500, Amit:300, Priya:200)");
        System.out.println("  3. Water Sports: ₹5000 (Percentage split - 40%,30%,20%,10%)");
    }

    // ✅ Business Logic: Show all balances
    public void showAllBalances() {
        userController.showAllBalances();
    }

    // ✅ Business Logic: Show specific user balance
    public void showUserBalance(String userId) {
        User user = userController.getUser(userId);
        if (user != null) {
            userController.showUserBalance(user);
        } else {
            System.out.println("User not found!");
        }
    }

    // ✅ Business Logic: Settle balance between users
    public void settleBalance(String fromUserId, String toUserId, double amount) {
        User fromUser = userController.getUser(fromUserId);
        User toUser = userController.getUser(toUserId);

        if (fromUser == null || toUser == null) {
            System.out.println("User not found!");
            return;
        }

        UserExpenseBalanceSheet fromSheet = fromUser.getUserExpenseBalanceSheet();
        UserExpenseBalanceSheet toSheet = toUser.getUserExpenseBalanceSheet();

        // Update balances
        Balance fromBalance = fromSheet.getUserVsBalance().get(toUserId);
        Balance toBalance = toSheet.getUserVsBalance().get(fromUserId);

        if (fromBalance != null && fromBalance.getAmountOwe() >= amount) {
            fromBalance.setAmountOwe(fromBalance.getAmountOwe() - amount);
            if (toBalance != null) {
                toBalance.setAmountGetBack(toBalance.getAmountGetBack() - amount);
            }

            fromSheet.setTotalYouOwe(fromSheet.getTotalYouOwe() - amount);
            toSheet.setTotalYouGotBack(toSheet.getTotalYouGotBack() - amount);

            System.out.println("✅ " + fromUser.getUsername() + " paid ₹" + amount +
                    " to " + toUser.getUsername());
        } else {
            System.out.println("❌ Invalid settlement amount! " +
                    fromUser.getUsername() + " owes ₹" +
                    (fromBalance != null ? fromBalance.getAmountOwe() : 0));
        }
    }
}