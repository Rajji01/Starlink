package com.starlink.backend.lld.strategy;

// ─── 3. CONTEXT — Strategy use karta hai ─────────────────
public class PaymentService {

    // Strategy field — runtime pe koi bhi inject ho sakti hai
    private PaymentStrategy strategy;

    // Constructor injection
    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // ✅ Runtime swap — ye wala Strategy ka superpower hai
    public void setStrategy(PaymentStrategy strategy) {
        System.out.println("\n[SWITCH] Payment method changed to: "
            + strategy.getMethodName());
        this.strategy = strategy;
    }

    // ✅ Algorithm delegate karo — context ko pata nahi andar kya chal raha
    public void processPayment(double amount) {
        System.out.println("\n--- Processing Rs." + amount
            + " via " + strategy.getMethodName() + " ---");

        if (!strategy.validate()) {
            System.out.println("[ERROR] Validation failed — payment cancelled");
            return;
        }

        strategy.pay(amount);
        System.out.println("[SUCCESS] Payment of Rs." + amount + " completed!\n");
    }
}