package com.starlink.backend.lld.facadedesignpattern.betterUber;

class LocationService {
    public boolean validateLocation(double lat, double lng) {
        System.out.println("Location validated: " + lat + ", " + lng);
        return true;
    }
    public double calculateDistance(double fromLat, double toLat) {
        return Math.abs(fromLat - toLat) * 111; // rough km
    }
}
