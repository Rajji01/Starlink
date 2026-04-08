package com.starlink.backend.lld.bridgedesignpattern.better;

// ─── IMPLEMENTATION INTERFACE ────────────────────────────
// "Kaise bhejein" — platform specific
public interface NotificationSender {
    void sendMessage(String recipient, String subject, String body);
    String getSenderType();
}