package com.starlink.backend.lld.facadedesignpattern.betterUber;

class DriverMatchingService {
    public String findNearestDriver(double lat, double lng) {
        System.out.println("Driver matching near " + lat + "," + lng);
        return "DRIVER_" + (int)(Math.random() * 100);
    }
}