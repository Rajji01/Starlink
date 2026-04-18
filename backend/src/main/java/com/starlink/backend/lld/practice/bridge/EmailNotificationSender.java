package com.starlink.backend.lld.practice.bridge;

public class EmailNotificationSender implements NotificationSender{
    @Override
    public void sendMessage(String msg, String userId) {
        System.out.println("sending this "+msg+" via Email to user id="+userId);
        //fetch userEmail via userId

    }

    @Override
    public String getType() {
        return "Email";
    }
}
