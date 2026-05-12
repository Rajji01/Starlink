package com.starlink.backend.hld.urlShortner;



public interface UrlShortenerService {
    
    /**
     * Create a short URL from long URL.
     */
    ShortenResponse shortenUrl(ShortenRequest request);

    /**
     * Get original long URL from short code.
     */
    String getLongUrl(String shortCode);
}