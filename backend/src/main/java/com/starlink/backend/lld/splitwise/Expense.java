package com.starlink.backend.lld.splitwise;

import java.util.List;

public class Expense {
    public int expenseId;
    private User user;
    private double amount;
    List<Split> splitDetails;
    String description;

    public Expense(int expenseId, User user, double amount, List<Split> splitDetails, String description) {
        this.expenseId = expenseId;
        this.user = user;
        this.amount = amount;
        this.splitDetails = splitDetails;
        this.description = description;
    }

    public Expense(int expenseId, User user, double amount, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.user = user;
        this.amount = amount;
        this.splitDetails = splitDetails;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }

    public void setSplitDetails(List<Split> splitDetails) {
        this.splitDetails = splitDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
