package com.starlink.backend.lld.bridgedesignpattern.better;// ─── CONCRETE IMPLEMENTATIONS ────────────────────────────

public class SmsSender implements NotificationSender {
    @Override
    public void sendMessage(String recipient, String subject, String body) {
        System.out.println("  [SMS] To: " + recipient);
        System.out.println("  [SMS] Msg: " + body.substring(0, Math.min(body.length(), 50)));
    }
    @Override public String getSenderType() { return "SMS"; }
}




