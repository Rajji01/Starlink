package com.starlink.backend.lld.mementodesignpattern;

// ─── 2. ORIGINATOR — actual object ──────────────────────
public class PaymentForm {

    private String upiId;
    private double amount;
    private String note;

    // State set karo
    public void fillForm(String upiId, double amount, String note) {
        this.upiId  = upiId;
        this.amount = amount;
        this.note   = note;
        System.out.println("Form filled: " + this);
    }

    // ✅ SAVE — snapshot banao (Memento create karo)
    public PaymentSnapshot save() {
        System.out.println("Snapshot saved!");
        return new PaymentSnapshot(upiId, amount, note);
    }

    // ✅ RESTORE — snapshot se wapas aao
    public void restore(PaymentSnapshot snapshot) {
        this.upiId  = snapshot.getUpiId();
        this.amount = snapshot.getAmount();
        this.note   = snapshot.getNote();
        System.out.println("Restored to: " + this);
    }

    public void clearForm() {
        this.upiId  = "";
        this.amount = 0;
        this.note   = "";
        System.out.println("Form CLEARED!");
    }

    @Override
    public String toString() {
        return "PaymentForm[upi=" + upiId
             + ", amount=" + amount + ", note=" + note + "]";
    }
}