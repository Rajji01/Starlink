package com.starlink.backend.hld.urlShortner;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlShortenerService urlShortenerService;

    /**
     * POST /api/v1/shorten
     * Create a new short URL.
     */
    @PostMapping("/api/v1/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ShortenResponse> shortenUrl(
            @Valid @RequestBody ShortenRequest request) {
        
        log.info("Received shorten request: {}", request);
        ShortenResponse response = urlShortenerService.shortenUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /{shortCode}
     * Redirect to original URL.
     */
    @GetMapping("/{shortCode}")
    public RedirectView redirect(@PathVariable String shortCode) {
        log.info("Redirect request for: {}", shortCode);
        String longUrl = urlShortenerService.getLongUrl(shortCode);
        
        // 302 redirect (temporary) - for analytics tracking
        RedirectView redirectView = new RedirectView(longUrl);
        redirectView.setStatusCode(HttpStatus.FOUND);
        return redirectView;
    }
}