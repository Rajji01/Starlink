package com.starlink.backend.lld.flyweight.zomato;

interface MapMarker {
    // extrinsic state bahar se aata hai — lat, lng, name
    void render(double lat, double lng, String restaurantName);
}