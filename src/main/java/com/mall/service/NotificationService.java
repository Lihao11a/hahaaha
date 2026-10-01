package com.mall.service;

public class NotificationService {
    public void sendOrderCreatedNotification(
            Long orderId,
            Long userId) {
        System.out.println(
                Thread.currentThread().getName()
                        + "：开始发送订单通知"
                        + "，orderId=" + orderId
                        + "，userId=" + userId
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new RuntimeException(
                    "发送通知被中断",
                    e
            );
        }

        System.out.println(
                Thread.currentThread().getName()
                        + "：订单通知发送完成"
                        + "，orderId=" + orderId
        );
    }
}
