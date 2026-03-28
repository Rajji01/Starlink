package com.starlink.backend.lld.flyweight.paytm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class TransactionIconFactory {

    // ConcurrentHashMap — thread-safe cache
    private static final Map<String, TransactionIcon> cache
            = new ConcurrentHashMap<>();

    // Private constructor — factory sirf static methods expose karta hai
    private TransactionIconFactory() {}

    public static TransactionIcon getIcon(String status) {
        // computeIfAbsent — atomic hai, race condition nahi hogi
        return cache.computeIfAbsent(status, k -> switch (k) {
            case "SUCCESS" -> new TransactionIcon(
                    "SUCCESS", "#4CAF50", "<svg>✓</svg>");
            case "FAILED"  -> new TransactionIcon(
                    "FAILED",  "#F44336", "<svg>✗</svg>");
            case "PENDING" -> new TransactionIcon(
                    "PENDING", "#FF9800", "<svg>⏳</svg>");
            default        -> new TransactionIcon(
                    "UNKNOWN", "#9E9E9E", "<svg>?</svg>");
        });
    }

    public static int getCacheSize() { return cache.size(); }

    public static void printCacheState() {
        System.out.println("\n  Cache mein hain: " + cache.keySet());
        System.out.println("  Total objects  : " + cache.size());
    }
}