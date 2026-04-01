package com.starlink.backend.lld.mementodesignpattern;

// ─── 1. MEMENTO — sealed snapshot ───────────────────────
// Caretaker isko store karta hai but andar jhank nahi sakta
final class PaymentSnapshot {

    // Private — sirf PaymentForm access kar sakta hai
    private final String upiId;
    private final double amount;
    private final String note;
    private final long   savedAt;

    // Package-private constructor — sirf PaymentForm banayega
    PaymentSnapshot(String upiId, double amount, String note) {
        this.upiId   = upiId;
        this.amount  = amount;
        this.note    = note;
        this.savedAt = System.currentTimeMillis();
    }

    // Getters bhi package-private — bahar se access nahi
    String getUpiId()  { return upiId; }
    double getAmount() { return amount; }
    String getNote()   { return note; }
    long   getSavedAt(){ return savedAt; }

    @Override
    public String toString() {
        return "Snapshot[upi=" + upiId + ", amt=" + amount + ", note=" + note + "]";
    }
}