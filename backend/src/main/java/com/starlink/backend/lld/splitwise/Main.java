package com.starlink.backend.lld.splitwise;

public class Main {
    public static void main(String[] args) {
        // Initialize SplitWise system
        SplitWise splitWise = new SplitWise();
        
        System.out.println("=== SPLITWISE DEMO ===\n");
        
        // Initialize demo data
        splitWise.initializeDemo();
        
        // Show all user balances
        System.out.println("=== ALL USERS BALANCE SHEETS ===");
        splitWise.showAllBalances();
        
        // Show specific user balance
        System.out.println("\n=== SPECIFIC USER BALANCE ===");
        splitWise.showUserBalance("1");
        
        // Settle balance
        System.out.println("\n=== SETTLING BALANCES ===");
        splitWise.settleBalance("2", "1", 500);
        
        // Show updated balances
        System.out.println("\n=== UPDATED BALANCES ===");
        splitWise.showUserBalance("1");
        splitWise.showUserBalance("2");
        
        System.out.println("\n=== SIMULATION COMPLETE ===");
    }
}