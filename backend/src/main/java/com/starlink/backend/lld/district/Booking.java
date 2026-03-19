package com.starlink.backend.lld.district;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Booking {
    private int bookingId;
    private Show show;
    private List<Seat> bookedSeats;
    private Payment payment;
    private Date bookingTime;
    private String status;  // CONFIRMED, CANCELLED

    public Booking(int bookingId, Show show, List<Seat> bookedSeats, Payment payment) {
        this.bookingId = bookingId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
        this.bookingTime = new Date();
        this.status = "CONFIRMED";
    }

    // ✅ Business Logic: Cancel booking
    public boolean cancelBooking() {
        if (new Date().before(show.getStartTime())) {
            // Can cancel if show hasn't started
            this.status = "CANCELLED";

            // Free up the seats
            List<Integer> seatIds = bookedSeats.stream()
                    .map(Seat::getSeatId)
                    .collect(Collectors.toList());
            show.getBookedSeats().removeAll(seatIds);

            System.out.println("Booking cancelled successfully!");
            return true;
        }
        System.out.println("Cannot cancel - show already started!");
        return false;
    }

    // ✅ Business Logic: Get total amount
    public double getTotalAmount() {
        return payment != null ? payment.getAmount() : 0;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
