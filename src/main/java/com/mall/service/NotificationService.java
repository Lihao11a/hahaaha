package com.mall.service;

import com.mall.notification.NotificationSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationSender
            notificationSender;

    public NotificationService(NotificationSender notificationSender) {

        this.notificationSender =
                notificationSender;
    }

    public void sendOrderSuccess(
            String userId) {

        notificationSender.send(
                userId,
                "您的订单创建成功"
        );

    }
}