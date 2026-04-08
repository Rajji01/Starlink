package com.starlink.backend.lld.bridgedesignpattern.better;

// Promo Notification
public class PromoNotification extends Notification {

    public PromoNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void send(String userId, String details) {
        System.out.println("\n[PROMO NOTIFICATION via " + sender.getSenderType() + "]");
        // Promo specific content
        String subject = "Special Offer — Zomato Gold";
        String body    = "Hey " + userId + "! " + details +
                         " | Use code GOLD50. Valid today only!";
        sender.sendMessage(userId, subject, body);
    }
}
