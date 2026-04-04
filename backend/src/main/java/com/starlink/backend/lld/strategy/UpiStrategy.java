package com.starlink.backend.lld.strategy;// ─── 2. CONCRETE STRATEGIES — har ek alag algorithm ──────

public class UpiStrategy implements PaymentStrategy {

    private final String upiId;

    public UpiStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean validate() {
        // UPI ID format check — real mein NPCI se validate hoga
        boolean valid = upiId != null && upiId.contains("@");
        System.out.println("[UPI] Validating UPI ID: " + upiId + " → " + (valid ? "Valid" : "Invalid"));
        return valid;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[UPI] Connecting to NPCI...");
        System.out.println("[UPI] Sending Rs." + amount + " to " + upiId);
        System.out.println("[UPI] Transfer complete!");
    }

    @Override
    public String getMethodName() { return "UPI"; }
}