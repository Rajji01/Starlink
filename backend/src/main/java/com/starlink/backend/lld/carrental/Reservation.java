package com.starlink.backend.lld.carrental;

import java.util.Date;

public class Reservation {
    private int id;
    private Vehicle vehicle;
    private Date fromDate;
    private Date lastDate;
    private User user;

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    ReservationStatus reservationStatus;
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    private  PaymentStatus paymentStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation(int id, Vehicle vehicle, Date fromDate, Date lastDate, User user) {
        this.id = id;
        this.vehicle = vehicle;
        this.fromDate = fromDate;
        this.lastDate = lastDate;
        this.user = user;
    }
}
