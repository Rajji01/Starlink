package com.starlink.backend.lld.bridgedesignpattern.better;

public class PushSender implements NotificationSender {
    @Override
    public void sendMessage(String recipient, String subject, String body) {
        System.out.println("  [PUSH] Device: " + recipient);
        System.out.println("  [PUSH] Title: " + subject);
        System.out.println("  [PUSH] Body: " + body);
    }
    @Override public String getSenderType() { return "PUSH"; }
}