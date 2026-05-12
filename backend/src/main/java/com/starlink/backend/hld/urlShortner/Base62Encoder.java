package com.starlink.backend.hld.urlShortner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Base62Encoder {

    private final UrlShortenerProperties properties;

    /**
     * Convert a long ID to Base62 short code.
     * Example: 1234567 → "aB3xY9"
     */
    public String encode(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be non-negative");
        }
        
        String charset = properties.getBase62Charset();
        int base = charset.length(); // 62
        
        StringBuilder sb = new StringBuilder();
        
        // Handle zero edge case
        if (id == 0) {
            return String.valueOf(charset.charAt(0));
        }
        
        // Convert to Base62
        while (id > 0) {
            int remainder = (int) (id % base);
            sb.append(charset.charAt(remainder));
            id = id / base;
        }
        
        return sb.reverse().toString();
    }

    /**
     * Convert Base62 short code back to long ID.
     * Example: "aB3xY9" → 1234567
     */
    public long decode(String shortCode) {
        if (shortCode == null || shortCode.isEmpty()) {
            throw new IllegalArgumentException("Short code cannot be empty");
        }
        
        String charset = properties.getBase62Charset();
        int base = charset.length();
        long result = 0;
        
        for (char c : shortCode.toCharArray()) {
            int index = charset.indexOf(c);
            if (index == -1) {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
            result = result * base + index;
        }
        
        return result;
    }
}