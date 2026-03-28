package com.starlink.backend.lld.flyweight.zomato;

import java.util.HashMap;
import java.util.Map;

// ====================================================
// FLYWEIGHT FACTORY — ye wala bahut important hai
// Factory ensure karta hai ki same type ka object
// DOBARA nahi banta — cache se return karta hai
// ====================================================
class MarkerFactory {

    // Cache — yahan shared objects stored hain
    private static final Map<String, RestaurantMarker> markerCache = new HashMap<>();

    public static MapMarker getMarker(String markerType) {
        // Pehle cache check karo
        if (!markerCache.containsKey(markerType)) {
            // Nahi mila — tabhi banao
            RestaurantMarker newMarker = switch (markerType) {
                case "veg"    -> new RestaurantMarker("veg",    "#4CAF50", "circle");
                case "nonveg" -> new RestaurantMarker("nonveg", "#F44336", "circle");
                case "cafe"   -> new RestaurantMarker("cafe",   "#FF9800", "star");
                case "bar"    -> new RestaurantMarker("bar",    "#9C27B0", "pin");
                default       -> new RestaurantMarker("default","#607D8B", "pin");
            };
            markerCache.put(markerType, newMarker);
        }
        // Cache se return karo — same object
        return markerCache.get(markerType);
    }

    public static int getCacheSize() {
        return markerCache.size();
    }
}