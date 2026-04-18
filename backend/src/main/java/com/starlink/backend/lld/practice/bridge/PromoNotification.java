package com.starlink.backend.lld.practice.bridge;

public class PromoNotification extends Notification{
    public PromoNotification(NotificationSender notificationSender) {
        super(notificationSender);
    }

    @Override
    public void sendMsg(String msg,String userId) {
        System.out.println("sending promo notification via ="+this.getNotificationSender().getType());
        this.getNotificationSender().sendMessage(msg,userId);
    }
}
