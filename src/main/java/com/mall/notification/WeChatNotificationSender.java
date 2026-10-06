package com.mall.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WeChatNotificationSender
        implements NotificationSender {

    @Override
    public void send(
            String userId,
            String message) {

        System.out.println(
                "微信通知用户："
                        + userId
                        + "，内容："
                        + message
        );

    }
}