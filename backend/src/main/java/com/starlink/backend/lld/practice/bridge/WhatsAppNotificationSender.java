package com.starlink.backend.lld.practice.bridge;

public class WhatsAppNotificationSender implements NotificationSender{
    @Override
    public void sendMessage(String msg, String userId) {
        System.out.println("sending this "+msg+" via whatsapp to user id="+userId);
        //fetch user whatsapp number via userId

    }

    @Override
    public String getType() {
        return "whatsapp";
    }
}
