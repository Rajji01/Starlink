package com.starlink.backend.lld.practice.bridge;

public class Client {
    public static void main(String[] args) {
        EmailNotificationSender emailNotificationSender= new EmailNotificationSender();
        WhatsAppNotificationSender whatsAppNotificationSender= new WhatsAppNotificationSender();
        Notification orderNotificationViaEmail= new OrderNotification(emailNotificationSender);
        Notification promoNotification= new PromoNotification(whatsAppNotificationSender);
        orderNotificationViaEmail.sendMsg("hi rajat this is order notifi","abc001");
        promoNotification.sendMsg("hi rajat this is promo notifi","abc001");
    }
}
