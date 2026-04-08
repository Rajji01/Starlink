package com.starlink.backend.lld.bridgedesignpattern.better;

public class EmailSender implements NotificationSender {
    @Override
    public void sendMessage(String recipient, String subject, String body) {
        System.out.println("  [EMAIL] To: " + recipient + "@zomato.com");
        System.out.println("  [EMAIL] Subject: " + subject);
        System.out.println("  [EMAIL] Body: " + body);
    }
    @Override public String getSenderType() { return "EMAIL"; }
}
