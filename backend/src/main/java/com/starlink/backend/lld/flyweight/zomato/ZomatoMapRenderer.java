package com.starlink.backend.lld.flyweight.zomato;

import java.util.List;

// ====================================================
// CLIENT CODE — Zomato Map rendering engine
// ====================================================
class ZomatoMapRenderer {

    // Ye represent karta hai ek restaurant ka data
    record RestaurantData(String name, String type, double lat, double lng) {}

    public static void main(String[] args) {

        // Delhi mein 50,000 restaurants — simulate karo
        List<RestaurantData> restaurants = List.of(
            new RestaurantData("Moti Mahal",     "nonveg", 28.6139, 77.2090),
            new RestaurantData("Haldirams",      "veg",    28.6200, 77.2100),
            new RestaurantData("Blue Tokai",     "cafe",   28.5921, 77.2292),
            new RestaurantData("Farzi Cafe",     "bar",    28.4595, 77.0266),
            new RestaurantData("Barbeque Nation","nonveg", 28.4700, 77.0300),
            new RestaurantData("Saravana Bhavan","veg",    28.6300, 77.2200),
            new RestaurantData("Third Wave",     "cafe",   28.5500, 77.2600)
            // ... imagine 49,993 more
        );

        // Map render karo
        for (RestaurantData r : restaurants) {
            // Factory se marker lo — SAME object milega same type ke liye
            MapMarker marker = MarkerFactory.getMarker(r.type());

            // Extrinsic state pass karo at render time
            marker.render(r.lat(), r.lng(), r.name());
        }

        System.out.println("\n--- Stats ---");
        System.out.println("Total restaurants rendered : " + restaurants.size());
        System.out.println("Total MarkerType objects   : " + MarkerFactory.getCacheSize());
        // Output: 7 restaurants, sirf 4 MarkerType objects!
        // 50,000 restaurants ke liye bhi sirf 4-5 objects!
    }
}