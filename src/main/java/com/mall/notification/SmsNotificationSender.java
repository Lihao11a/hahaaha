package com.mall.notification;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationSender
        implements NotificationSender {

    @Override
    public void send(
            String userId,
            String message) {

        System.out.println(
                "短信通知用户："
                        + userId
                        + "，内容："
                        + message
        );

    }
}