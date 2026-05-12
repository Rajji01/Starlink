package com.starlink.backend.hld.urlShortner;


import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UrlRepository {

    // In-memory storage (Day 1)
    // Day 2 mein ye DynamoDB se replace hoga
    private final ConcurrentHashMap<String, Url> urlStorage = new ConcurrentHashMap<>();
    
    // Counter for unique ID generation
    private final AtomicLong counter = new AtomicLong(1000000L); // Start from 1M

    public Url save(Url url) {
        urlStorage.put(url.getShortCode(), url);
        return url;
    }

    public Optional<Url> findByShortCode(String shortCode) {
        return Optional.ofNullable(urlStorage.get(shortCode));
    }

    public boolean existsByShortCode(String shortCode) {
        return urlStorage.containsKey(shortCode);
    }

    public long getNextId() {
        return counter.incrementAndGet();
    }

    public void delete(String shortCode) {
        urlStorage.remove(shortCode);
    }

    public int size() {
        return urlStorage.size();
    }
}