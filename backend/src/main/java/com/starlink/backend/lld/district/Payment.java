package com.starlink.backend.lld.district;

public class Payment {
    private int paymentId;
    private double amount;
    private String status;  // PENDING, COMPLETED, FAILED
    private String method;  // CARD, UPI, CASH

    // ✅ Business Logic: Process payment
    public boolean processPayment(double amount, String method) {
        this.amount = amount;
        this.method = method;
        this.status = "COMPLETED";  // Simulate successful payment
        System.out.println("Payment of ₹" + amount + " processed via " + method);
        return true;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
