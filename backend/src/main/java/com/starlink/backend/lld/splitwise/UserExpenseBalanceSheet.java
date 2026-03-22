package com.starlink.backend.lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Balance> userVsBalance;  // userId vs Balance
    private double totalYourExpense;
    private double totalPayment;
    private double totalYouOwe;
    private double totalYouGotBack;

    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        this.totalYourExpense = 0;
        this.totalPayment = 0;
        this.totalYouOwe = 0;
        this.totalYouGotBack = 0;
    }

    // ✅ Business Logic: Update balance when expense added
    public void updateBalance(String userId, double amount, boolean isOwedToYou) {
        Balance balance = userVsBalance.getOrDefault(userId, new Balance());

        if (isOwedToYou) {
            // Someone owes money to you
            balance.setAmountGetBack(balance.getAmountGetBack() + amount);
            totalYouGotBack += amount;
        } else {
            // You owe money to someone
            balance.setAmountOwe(balance.getAmountOwe() + amount);
            totalYouOwe += amount;
        }

        userVsBalance.put(userId, balance);
    }

    // Getters and Setters
    public Map<String, Balance> getUserVsBalance() { return userVsBalance; }
    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }
    public double getTotalYourExpense() { return totalYourExpense; }
    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }
    public double getTotalPayment() { return totalPayment; }
    public void setTotalPayment(double totalPayment) { this.totalPayment = totalPayment; }
    public double getTotalYouOwe() { return totalYouOwe; }
    public void setTotalYouOwe(double totalYouOwe) { this.totalYouOwe = totalYouOwe; }
    public double getTotalYouGotBack() { return totalYouGotBack; }
    public void setTotalYouGotBack(double totalYouGotBack) {
        this.totalYouGotBack = totalYouGotBack;
    }
}