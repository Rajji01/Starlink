package com.starlink.backend.lld.carrental;

public class Payment {
    private Bill bill;

    // ... getters/setters ...

    // ✅ FIXED: Correct method name and implementation
    public void payBill(Bill bill) {
        this.bill = bill;
        Reservation reservation = bill.getReservation();

        // Payment logic here
        System.out.println("Processing payment for reservation: " +
                reservation.getId());

        // Update payment status
        reservation.setPaymentStatus(PaymentStatus.COMPLETED);

        // Generate invoice etc.
        System.out.println("Payment successful!");
    }
}