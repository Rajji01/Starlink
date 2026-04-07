package com.starlink.backend.lld.facadedesignpattern.betterUber;// ===== UBER FACADE =====

class RideFacade {

    private final LocationService      locationService;
    private final DriverMatchingService driverService;
    private final SurgePricingService  pricingService;
    private final TripService          tripService;

    public RideFacade() {
        this.locationService = new LocationService();
        this.driverService   = new DriverMatchingService();
        this.pricingService  = new SurgePricingService();
        this.tripService     = new TripService();
    }

    public RideBooking bookRide(String userId,
                                 double pickupLat, double pickupLng,
                                 double dropLat,   double dropLng) {

        // 1. Locations valid hain?
        if (!locationService.validateLocation(pickupLat, pickupLng)) {
            throw new RuntimeException("Invalid pickup location");
        }

        // 2. Nearest driver dhundo
        String driverId = driverService.findNearestDriver(pickupLat, pickupLng);

        // 3. Distance aur fare nikalo
        double distance = locationService.calculateDistance(pickupLat, dropLat);
        double surge    = pricingService.getSurgeMultiplier(pickupLat, pickupLng);
        double fare     = pricingService.calculateFare(distance, surge);

        // 4. Trip start karo
        String tripId = tripService.startTrip(driverId, userId);

        return new RideBooking(tripId, driverId, fare);
    }
}