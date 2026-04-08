package com.starlink.backend.lld.bridgedesignpattern.better;

// ─── ABSTRACTION ─────────────────────────────────────────
// "Kya bhejein" — notification type
// Implementation ka HAS-A reference rakha hai — BRIDGE
public abstract class Notification {

    // ✅ BRIDGE — implementation inject hoti hai
    protected NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    // Runtime pe sender swap karo
    public void setSender(NotificationSender sender) {
        this.sender = sender;
    }

    // Abstract — child define kare kya content hoga
    public abstract void send(String userId, String details);
}