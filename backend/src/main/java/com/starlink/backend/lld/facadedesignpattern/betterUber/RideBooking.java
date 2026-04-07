package com.starlink.backend.lld.facadedesignpattern.betterUber;

class RideBooking {
    String tripId, driverId;
    double estimatedFare;

    RideBooking(String tripId, String driverId, double estimatedFare) {
        this.tripId = tripId;
        this.driverId = driverId;
        this.estimatedFare = estimatedFare;
        System.out.printf("RIDE BOOKED! Trip: %s | Driver: %s | Fare: Rs.%.1f%n",
            tripId, driverId, estimatedFare);
    }
}