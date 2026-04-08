package com.starlink.backend.lld.bridgedesignpattern.better;// ─── REFINED ABSTRACTIONS ─────────────────────────────────

// Order Notification
public class OrderNotification extends Notification {

    public OrderNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void send(String userId, String details) {
        System.out.println("\n[ORDER NOTIFICATION via " + sender.getSenderType() + "]");
        // Order specific content
        String subject = "Order Update — Zomato";
        String body    = "Hi " + userId + "! Your order status: " + details +
                         ". Track at zomato.com/track";
        sender.sendMessage(userId, subject, body); // delegate to implementation
    }
}


