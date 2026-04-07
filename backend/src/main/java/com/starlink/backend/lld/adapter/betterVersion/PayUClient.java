package com.starlink.backend.lld.adapter.betterVersion;

public class PayUClient {
    public int makePayment(long mobileNumber, float rupees) {
        System.out.println("  [PayU SDK] Payment of Rs." + rupees
            + " from mobile: " + mobileNumber);
        return (int)(Math.random() * 100000); // transaction ID
    }

    public boolean initiateRefund(int payuTxnId) {
        System.out.println("  [PayU SDK] Refunding txn: " + payuTxnId);
        return true;
    }
}