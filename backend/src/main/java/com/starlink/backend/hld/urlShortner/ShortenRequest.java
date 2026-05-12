package com.starlink.backend.hld.urlShortner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ShortenRequest {

    @NotBlank(message = "Long URL is required")
    @Pattern(
        regexp = "^(https?)://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?$",
        message = "Invalid URL format"
    )
    @Size(max = 2048, message = "URL too long (max 2048 chars)")
    private String longUrl;

    @Size(min = 4, max = 20, message = "Custom alias must be 4-20 chars")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid alias chars")
    private String customAlias;

    private Integer expiryDays;
    private String userId;
}