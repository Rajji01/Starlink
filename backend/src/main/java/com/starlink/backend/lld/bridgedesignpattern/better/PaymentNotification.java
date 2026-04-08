package com.starlink.backend.lld.bridgedesignpattern.better;

// Payment Notification
public class PaymentNotification extends Notification {

    public PaymentNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void send(String userId, String details) {
        System.out.println("\n[PAYMENT NOTIFICATION via " + sender.getSenderType() + "]");
        String subject = "Payment Confirmation — Zomato";
        String body    = "Payment of " + details + " received. Thank you " + userId + "!";
        sender.sendMessage(userId, subject, body);
    }
}