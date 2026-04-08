package com.starlink.backend.lld.bridgedesignpattern.better;

public class WhatsAppSender implements NotificationSender {
    @Override
    public void sendMessage(String recipient, String subject, String body) {
        System.out.println("  [WHATSAPP] To: +91" + recipient);
        System.out.println("  [WHATSAPP] Msg: " + body);
    }
    @Override public String getSenderType() { return "WHATSAPP"; }
}