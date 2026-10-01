package com.mall.demo;

import com.mall.config.AppExecutors;
import com.mall.service.NotificationService;

import java.util.concurrent.ThreadPoolExecutor;

public class AsyncNotificationDemo {

    public static void main(String[] args) {

        AppExecutors appExecutors =
                new AppExecutors();

        ThreadPoolExecutor executor =
                appExecutors
                        .getNotificationExecutor();

        NotificationService notificationService =
                new NotificationService();

        System.out.println(
                Thread.currentThread().getName()
                        + "：订单创建成功"
        );


        for (long i = 1; i <= 20; i++) {

            long orderId = 20000L + i;

            executor.submit(() -> {

                notificationService
                        .sendOrderCreatedNotification(
                                orderId,
                                10001L
                        );

            });
        }
//        executor.submit(() -> {
//
//            notificationService
//                    .sendOrderCreatedNotification(
//                            20001L,
//                            10001L
//                    );
//
//        });

        System.out.println(
                Thread.currentThread().getName()
                        + "：订单主流程继续执行"
        );

        appExecutors.shutdown();
    }
}