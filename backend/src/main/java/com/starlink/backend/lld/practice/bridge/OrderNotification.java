package com.starlink.backend.lld.practice.bridge;

public class OrderNotification extends Notification{
    public OrderNotification(NotificationSender notificationSender) {
        super(notificationSender);
    }

    @Override
    public void sendMsg(String msg,String userId) {
        System.out.println("sending order notification via ="+this.getNotificationSender().getType());
        this.getNotificationSender().sendMessage(msg,userId);
    }


}
