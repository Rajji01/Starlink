package com.starlink.backend.lld.bridgedesignpattern.better;

// ─── CLIENT ──────────────────────────────────────────────
public class ZomatoNotificationClient {

    public static void main(String[] args) {

        System.out.println("=".repeat(55));
        System.out.println("  BRIDGE PATTERN — Zomato Notifications");
        System.out.println("=".repeat(55));

        // ─── Implementations ──────────────────────────────
        NotificationSender sms      = new SmsSender();
        NotificationSender email    = new EmailSender();
        NotificationSender push     = new PushSender();
        NotificationSender whatsapp = new WhatsAppSender();

        // ─── Order Notification — alag senders ke saath ──
        System.out.println("\n--- Order Notifications ---");

        Notification orderNotif = new OrderNotification(sms);
        orderNotif.send("USER_001", "OUT FOR DELIVERY");

        orderNotif.setSender(email); // ✅ runtime swap!
        orderNotif.send("USER_001", "DELIVERED");

        orderNotif.setSender(push); // ✅ phir swap
        orderNotif.send("USER_001", "ARRIVING IN 5 MINS");

        // ─── Promo Notification ───────────────────────────
        System.out.println("\n--- Promo Notifications ---");

        Notification promoNotif = new PromoNotification(whatsapp);
        promoNotif.send("USER_002", "50% off on your next order!");

        promoNotif.setSender(email);
        promoNotif.send("USER_003", "Buy 1 Get 1 Free today!");

        // ─── Payment Notification ─────────────────────────
        System.out.println("\n--- Payment Notifications ---");

        Notification payNotif = new PaymentNotification(sms);
        payNotif.send("USER_004", "Rs.450");

        // ─── Same sender — different notifications ─────────
        System.out.println("\n--- Same SMS Sender, Different Notifications ---");
        // SMS sender ek hai — teen notifications use kar sakti hain
        Notification n1 = new OrderNotification(sms);
        Notification n2 = new PromoNotification(sms);
        Notification n3 = new PaymentNotification(sms);

        n1.send("USER_005", "CONFIRMED");
        n2.send("USER_005", "Special weekend deal!");
        n3.send("USER_005", "Rs.299");
    }
}