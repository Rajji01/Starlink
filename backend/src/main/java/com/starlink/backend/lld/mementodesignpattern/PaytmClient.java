package com.starlink.backend.lld.mementodesignpattern;

// ─── 4. CLIENT — use karo ───────────────────────────────
public class PaytmClient {
    public static void main(String[] args) {

        PaymentForm form    = new PaymentForm();
        UndoManager manager = new UndoManager(form);

        System.out.println("=== Paytm Payment Undo Demo ===\n");

        // State 1
        form.fillForm("merchant@okaxis", 499.0, "Zomato order");
        manager.saveState(); // snapshot 1 save

        // State 2
        form.fillForm("shop@ybl", 1299.0, "Amazon purchase");
        manager.saveState(); // snapshot 2 save

        // State 3 — save nahi kiya
        form.fillForm("friend@paytm", 500.0, "Split bill");

        System.out.println("\n--- Undo ---");
        manager.undo(); // State 2 pe wapas
        manager.undo(); // State 1 pe wapas
        manager.undo(); // Nothing to undo!

        System.out.println("\n--- Redo ---");
        manager.redo(); // State 2 pe aage
    }
}

//
//```
//        ```
//Output:
//        === Paytm Payment Undo Demo ===
//
//Form filled: PaymentForm[upi=merchant@okaxis, amount=499.0, note=Zomato order]
//Snapshot saved!
//Undo stack size: 1
//Form filled: PaymentForm[upi=shop@ybl, amount=1299.0, note=Amazon purchase]
//Snapshot saved!
//Undo stack size: 2
//Form filled: PaymentForm[upi=friend@paytm, amount=500.0, note=Split bill]
//
//        --- Undo ---
//Snapshot saved!
//Restored to: PaymentForm[upi=shop@ybl, amount=1299.0, note=Amazon purchase]
//Snapshot saved!
//Restored to: PaymentForm[upi=merchant@okaxis, amount=499.0, note=Zomato order]
//Nothing to undo!
//
//        --- Redo ---
//Restored to: PaymentForm[upi=shop@ybl, amount=1299.0, note=Amazon purchase]