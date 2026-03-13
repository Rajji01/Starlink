package com.starlink.backend.lld.carrental;

import java.util.Date;

public class Bill {
    private Reservation reservation;
    private double amount;
    private Date billDate;
    private boolean isPaid;

    // ✅ FIXED: Constructor should set the reservation
    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.billDate = new Date();
        this.isPaid = false;
        this.amount = calculateAmount(reservation);
    }

    private double calculateAmount(Reservation reservation) {
        // Calculate based on vehicle type, hours/days, etc.
        return 1000.0; // Placeholder
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // Add other getters/setters
}