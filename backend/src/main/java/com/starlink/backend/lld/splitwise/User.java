package com.starlink.backend.lld.splitwise;

public class User {
    private String id;
    private String username;
    private UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();  // Initialize
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
    public void setUserExpenseBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }
}