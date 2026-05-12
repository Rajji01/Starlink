package com.starlink.backend.hld.urlShortner;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "url-shortener")
public class UrlShortenerProperties {
    private String baseUrl;
    private int shortCodeLength;
    private String base62Charset;
    private int defaultExpiryDays;
}