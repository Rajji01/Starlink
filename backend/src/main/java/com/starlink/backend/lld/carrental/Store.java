package com.starlink.backend.lld.carrental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {
    private int storeid;
    private Location location;
    private VehicleInventory vehicleInventory;
    private List<Reservation> reservation;

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
    public  List<Vehicle> getVehicles(VehicleType vehicleType){
      return   vehicleInventory.findVehicle(vehicleType);
    }
//    public Reservation createReservation(Vehicle vehicle,User user){
//        Reservation reservation1= new Reservation( 1,  vehicle, new Date(), new Date(),user);
//        return reservation1;
//    }
//    // ✅ FIXED: Added completeReservation method
//    public void completeReservation(int reservationId) {
//        for (Reservation reservation : reservation) {
//            if (reservation.getId() == reservationId) {
//                reservation.setReservationStatus(ReservationStatus.COMPLETED);
//                // Mark vehicle as available
//                Vehicle vehicle = reservation.getVehicle();
//                vehicle.setStatus(Status.AVAILABLE);
//                System.out.println("Reservation " + reservationId + " completed successfully!");
//                return;
//            }
//        }
//        System.out.println("Reservation not found!");
//    }
    public Store() {
        this.reservation = new ArrayList<>();  // ✅ FIX: Initialize empty list
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        // ✅ FIX: Check if vehicle is available
        if (vehicle.getStatus() != Status.AVAILABLE) {
            System.out.println("Vehicle not available!");
            return null;
        }

        Reservation reservation1 = new Reservation(1, vehicle, new Date(), new Date(), user);
        reservation1.setReservationStatus(ReservationStatus.SCHEDULED);
        reservation1.setPaymentStatus(PaymentStatus.PENDING);

        // Update vehicle status
        vehicle.setStatus(Status.BOOKED);

        // ✅ FIX: Add to store's reservation list (list already initialized in constructor)
        this.reservation.add(reservation1);

        return reservation1;
    }

    public void completeReservation(int reservationId) {
        // ✅ FIX: Check if reservation list is null (though it won't be now)
        if (reservation == null || reservation.isEmpty()) {
            System.out.println("No reservations found!");
            return;
        }

        for (Reservation res : reservation) {
            if (res.getId() == reservationId) {
                res.setReservationStatus(ReservationStatus.COMPLETED);
                // Mark vehicle as available
                Vehicle vehicle = res.getVehicle();
                if (vehicle != null) {
                    vehicle.setStatus(Status.AVAILABLE);
                }
                System.out.println("Reservation " + reservationId + " completed successfully!");
                return;
            }
        }
        System.out.println("Reservation " + reservationId + " not found!");
    }
}
