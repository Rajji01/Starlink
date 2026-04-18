package com.starlink.backend.lld.practice.bridge;

public abstract class Notification {
    private NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void setNotificationSender(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public NotificationSender getNotificationSender() {
        return notificationSender;
    }

    public abstract void sendMsg(String msg, String userId);
}
