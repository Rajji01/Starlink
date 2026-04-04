package com.starlink.backend.lld.strategy;

public class NetBankingStrategy implements PaymentStrategy {

    private final String bankCode;
    private final String userId;

    public NetBankingStrategy(String bankCode, String userId) {
        this.bankCode = bankCode;
        this.userId   = userId;
    }

    @Override
    public boolean validate() {
        boolean valid = bankCode != null && !bankCode.isEmpty();
        System.out.println("[NETBANKING] Bank: " + bankCode
            + " → " + (valid ? "Supported" : "Unsupported"));
        return valid;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[NETBANKING] Redirecting to " + bankCode + " portal...");
        System.out.println("[NETBANKING] OTP sent to registered mobile");
        System.out.println("[NETBANKING] Rs." + amount + " transferred from " + userId);
    }

    @Override
    public String getMethodName() { return "Net Banking (" + bankCode + ")"; }
}