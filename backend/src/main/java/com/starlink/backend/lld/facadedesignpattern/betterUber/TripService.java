package com.starlink.backend.lld.facadedesignpattern.betterUber;

class TripService {
    public String startTrip(String driverId, String userId) {
        String tripId = "TRIP_" + System.currentTimeMillis();
        System.out.println("Trip started: " + tripId);
        return tripId;
    }
}