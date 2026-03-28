package com.starlink.backend.lld.flyweight.paytm;

import java.util.List;

public class PaytmTransactionClient {

    // Real transaction data — Paytm history jaisi
    record Transaction(
        String txnId,
        double amount,
        String merchant,
        String status,
        long timestamp
    ) {}

    public static void main(String[] args) {

        // ----------------------------------------
        // REAL TEST DATA — Paytm transaction history
        // ----------------------------------------
        List<Transaction> transactions = List.of(
            new Transaction("TXN001", 499.00,  "Zomato Order",         "SUCCESS", 1710000001L),
            new Transaction("TXN002", 1299.00, "Myntra - Shoes",        "SUCCESS", 1710000120L),
            new Transaction("TXN003", 50.00,   "Metro Recharge",        "FAILED",  1710000250L),
            new Transaction("TXN004", 799.00,  "BookMyShow Tickets",    "SUCCESS", 1710000380L),
            new Transaction("TXN005", 3200.00, "IRCTC Train Ticket",    "PENDING", 1710000500L),
            new Transaction("TXN006", 149.00,  "Hotstar Subscription",  "SUCCESS", 1710000620L),
            new Transaction("TXN007", 670.00,  "Swiggy Order",          "FAILED",  1710000740L),
            new Transaction("TXN008", 2500.00, "Electricity Bill - BSES","SUCCESS",1710000860L),
            new Transaction("TXN009", 99.00,   "GPay Cashback",         "PENDING", 1710000980L),
            new Transaction("TXN010", 5000.00, "Amazon - Mobile",       "SUCCESS", 1710001100L)
        );

        System.out.println("=".repeat(75));
        System.out.println("  PAYTM TRANSACTION HISTORY — Flyweight Demo");
        System.out.println("=".repeat(75));

        // Render karo — factory se icon lo
        for (Transaction txn : transactions) {

            // Factory decide karta hai — naya banao ya cache se do
            TransactionIcon icon = TransactionIconFactory.getIcon(txn.status());

            System.out.printf("%n  TxnId: %s%n  ", txn.txnId());
            icon.render(txn.amount(), txn.merchant(), txn.timestamp());
        }

        // ----------------------------------------
        // PROOF — kitne objects bane actually?
        // ----------------------------------------
        System.out.println("\n" + "=".repeat(75));
        System.out.println("  MEMORY PROOF");
        System.out.println("=".repeat(75));
        System.out.println("  Total transactions rendered : " + transactions.size());
        TransactionIconFactory.printCacheState();

        // Same object hai verify karo
        TransactionIcon icon1 = TransactionIconFactory.getIcon("SUCCESS");
        TransactionIcon icon2 = TransactionIconFactory.getIcon("SUCCESS");
        TransactionIcon icon3 = TransactionIconFactory.getIcon("SUCCESS");

        System.out.println("\n  SUCCESS icon — same object hai?");
        System.out.println("  icon1 == icon2 : " + (icon1 == icon2)); // true
        System.out.println("  icon2 == icon3 : " + (icon2 == icon3)); // true
        System.out.println("  hashCode same  : "
            + (icon1.hashCode() == icon2.hashCode())); // true

        System.out.println("\n" + "=".repeat(75));
        System.out.println("  10 transactions, sirf 3 objects — Flyweight working!");
        System.out.println("=".repeat(75));
    }
}
//
//```
//
//        ---
//
//        ### Output
//```
//        ===========================================================================
//PAYTM TRANSACTION HISTORY — Flyweight Demo
//===========================================================================
//
//TxnId: TXN001
//  [NEW OBJECT CREATED] TransactionIcon: SUCCESS
//  [SUCCESS]  |  color=#4CAF50  |  Rs.  499.00  |  Zomato Order             |  ts=1710000001
//
//TxnId: TXN002
//  [SUCCESS]  |  color=#4CAF50  |  Rs. 1299.00  |  Myntra - Shoes           |  ts=1710000120
//
//TxnId: TXN003
//  [NEW OBJECT CREATED] TransactionIcon: FAILED
//  [FAILED]   |  color=#F44336  |  Rs.   50.00  |  Metro Recharge           |  ts=1710000250
//
//TxnId: TXN004
//  [SUCCESS]  |  color=#4CAF50  |  Rs.  799.00  |  BookMyShow Tickets       |  ts=1710000380
//
//TxnId: TXN005
//  [NEW OBJECT CREATED] TransactionIcon: PENDING
//  [PENDING]  |  color=#FF9800  |  Rs. 3200.00  |  IRCTC Train Ticket       |  ts=1710000500
//
//TxnId: TXN006
//  [SUCCESS]  |  color=#4CAF50  |  Rs.  149.00  |  Hotstar Subscription     |  ts=1710000620
//
//TxnId: TXN007
//  [FAILED]   |  color=#F44336  |  Rs.  670.00  |  Swiggy Order             |  ts=1710000740
//
//TxnId: TXN008
//  [SUCCESS]  |  color=#4CAF50  |  Rs. 2500.00  |  Electricity Bill - BSES  |  ts=1710000860
//
//TxnId: TXN009
//  [PENDING]  |  color=#FF9800  |  Rs.   99.00  |  GPay Cashback            |  ts=1710000980
//
//TxnId: TXN010
//  [SUCCESS]  |  color=#4CAF50  |  Rs. 5000.00  |  Amazon - Mobile          |  ts=1710001100
//
//        ===========================================================================
//MEMORY PROOF
//===========================================================================
//Total transactions rendered : 10
//
//Cache mein hain: [SUCCESS, FAILED, PENDING]
//Total objects  : 3
//
//SUCCESS icon — same object hai?
//icon1 == icon2 : true
//icon2 == icon3 : true
//hashCode same  : true
//
//        ===========================================================================
//        10 transactions, sirf 3 objects — Flyweight working!
//        ===========================================================================