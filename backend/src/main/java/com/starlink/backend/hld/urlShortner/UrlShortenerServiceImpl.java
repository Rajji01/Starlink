package com.starlink.backend.hld.urlShortner;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlRepository urlRepository;
    private final Base62Encoder base62Encoder;
    private final UrlShortenerProperties properties;



    @Override
    public ShortenResponse shortenUrl(ShortenRequest request) {
        log.info("Shortening URL: {}", request.getLongUrl());
        
        String shortCode;
        
        // Custom alias flow
        if (request.getCustomAlias() != null && !request.getCustomAlias().isBlank()) {
            shortCode = request.getCustomAlias();
            
            if (urlRepository.existsByShortCode(shortCode)) {
                throw new InvalidUrlException(
                    "Custom alias already exists: " + shortCode
                );
            }
        } 
        // Auto-generate flow
        else {
            long id = urlRepository.getNextId();
            shortCode = base62Encoder.encode(id);
        }
        
        // Calculate expiry
        int expiryDays = request.getExpiryDays() != null 
            ? request.getExpiryDays() 
            : properties.getDefaultExpiryDays();
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiresAt = now.plusDays(expiryDays);
        
        // Build entity
        Url url = Url.builder()
                .shortCode(shortCode)
                .longUrl(request.getLongUrl())
                .userId(request.getUserId())
                .createdAt(now)
                .expiresAt(expiresAt)
                .clickCount(0L)
                .isActive(true)
                .build();
        
        // Save
        urlRepository.save(url);
        
        log.info("URL shortened successfully: {} → {}", 
                request.getLongUrl(), shortCode);
        
        // Build response
        return ShortenResponse.builder()
                .shortUrl(properties.getBaseUrl() + "/" + shortCode)
                .shortCode(shortCode)
                .longUrl(request.getLongUrl())
                .createdAt(now)
                .expiresAt(expiresAt)
                .build();
    }

    @Override
    public String getLongUrl(String shortCode) {
        log.info("Fetching long URL for: {}", shortCode);
        
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException(
                    "Short URL not found: " + shortCode
                ));
        
        // Check if expired
        if (url.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new UrlNotFoundException("Short URL expired: " + shortCode);
        }
        
        // Check if active
        if (!url.getIsActive()) {
            throw new UrlNotFoundException("Short URL is disabled: " + shortCode);
        }
        
        // Increment click count (in production: async via Kafka)
        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);
        
        log.info("Redirecting {} → {} (clicks: {})", 
                shortCode, url.getLongUrl(), url.getClickCount());
        
        return url.getLongUrl();
    }
}