package com.starlink.backend.lld.strategy;

public class WalletStrategy implements PaymentStrategy {

    private final String userId;
    private double       walletBalance;

    public WalletStrategy(String userId, double walletBalance) {
        this.userId        = userId;
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean validate() {
        // Wallet mein enough balance hai?
        boolean valid = walletBalance > 0;
        System.out.println("[WALLET] Balance check: Rs." + walletBalance
            + " → " + (valid ? "Sufficient" : "Insufficient"));
        return valid;
    }

    @Override
    public void pay(double amount) {
        if (walletBalance < amount) {
            System.out.println("[WALLET] Insufficient balance! Rs."
                + walletBalance + " available, Rs." + amount + " needed");
            return;
        }
        walletBalance -= amount;
        System.out.println("[WALLET] Rs." + amount + " deducted for user " + userId);
        System.out.println("[WALLET] Remaining balance: Rs." + walletBalance);
    }

    @Override
    public String getMethodName() { return "Paytm Wallet"; }
}