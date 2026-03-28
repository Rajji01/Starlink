package com.starlink.backend.lld.flyweight.zomato;

// ====================================================
// CONCRETE FLYWEIGHT — Intrinsic state yahan hai
// Ye object SHARED hai — ek baar banta hai, hazaron
// markers use karte hain
// ====================================================
class RestaurantMarker implements MapMarker {

    // INTRINSIC STATE — shared, immutable, andar stored
    private final String markerType;   // "veg", "nonveg", "cafe"
    private final String iconColor;    // "#4CAF50", "#F44336"
    private final String iconShape;    // "circle", "pin", "star"
    private final byte[] iconImageData; // actual icon bytes — heavy object!

    public RestaurantMarker(String markerType, String iconColor, String iconShape) {
        this.markerType  = markerType;
        this.iconColor   = iconColor;
        this.iconShape   = iconShape;
        // Heavy operation — sirf ek baar hogi
        this.iconImageData = loadIconFromDisk(markerType);
        System.out.println("*** NEW MarkerType created: " + markerType + " ***");
    }

    private byte[] loadIconFromDisk(String type) {
        // Disk se icon load karo — expensive operation
        return new byte[1024]; // simulated
    }

    // EXTRINSIC STATE — har call pe pass hota hai
    @Override
    public void render(double lat, double lng, String restaurantName) {
        System.out.printf("Rendering [%s] marker at (%.4f, %.4f) for '%s' | color=%s%n",
            markerType, lat, lng, restaurantName, iconColor);
    }
}