package com.starlink.backend.lld.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserController {
    List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    // ✅ Business Logic: Add new user
    public User addUser(String id, String username) {
        User user = new User(id, username);
        userList.add(user);
        return user;
    }

    // ✅ Business Logic: Get user by ID
    public User getUser(String userId) {
        return userList.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    // ✅ Business Logic: Get all users
    public List<User> getAllUsers() {
        return userList;
    }

    // ✅ Business Logic: Show all users balance sheets
    public void showAllBalances() {
        for (User user : userList) {
            showUserBalance(user);
        }
    }

    // ✅ Business Logic: Show specific user's balance
    public void showUserBalance(User user) {
        System.out.println("\n=== Balance Sheet for " + user.getUsername() + " ===");
        UserExpenseBalanceSheet sheet = user.getUserExpenseBalanceSheet();

        System.out.println("Total Your Expense: ₹" + sheet.getTotalYourExpense());
        System.out.println("Total Payment: ₹" + sheet.getTotalPayment());
        System.out.println("Total You Owe: ₹" + sheet.getTotalYouOwe());
        System.out.println("Total You Got Back: ₹" + sheet.getTotalYouGotBack());

        System.out.println("\nIndividual Balances:");
        for (Map.Entry<String, Balance> entry : sheet.getUserVsBalance().entrySet()) {
            String userId = entry.getKey();
            Balance balance = entry.getValue();

            User otherUser = getUser(userId);
            if (otherUser != null) {
                if (balance.getAmountOwe() > 0) {
                    System.out.println("  You owe " + otherUser.getUsername() + ": ₹" + balance.getAmountOwe());
                }
                if (balance.getAmountGetBack() > 0) {
                    System.out.println("  " + otherUser.getUsername() + " owes you: ₹" + balance.getAmountGetBack());
                }
            }
        }
    }
}