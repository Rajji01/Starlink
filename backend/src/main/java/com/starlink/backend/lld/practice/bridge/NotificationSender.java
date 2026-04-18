package com.starlink.backend.lld.practice.bridge;

public interface NotificationSender {
    public void sendMessage(String msg,String userId);
    public String getType();
}
