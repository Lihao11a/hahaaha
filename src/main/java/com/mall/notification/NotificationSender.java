package com.mall.notification;

public interface NotificationSender {

    void send(
            String userId,
            String message
    );

}