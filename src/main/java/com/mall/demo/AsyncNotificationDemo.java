package com.mall.demo;

import com.mall.config.AppExecutors;
import com.mall.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class AsyncNotificationDemo {

    @Autowired
    private NotificationService notificationService;
    public static void main(String[] args) {

        System.out.println("hahahahah");
//        AppExecutors appExecutors =
//                new AppExecutors();
//
//        ThreadPoolExecutor executor =
//                appExecutors
//                        .getNotificationExecutor();
//
//        NotificationService notificationService = notificationService;
//
//
//        System.out.println(
//                Thread.currentThread().getName()
//                        + "：订单创建成功"
//        );


//        for (long i = 1; i <= 20; i++) {
//
//            long orderId = 20000L + i;
//
//            executor.submit(() -> {
//
//                notificationService
//                        .sendOrderCreatedNotification(
//                                orderId,
//                                10001L
//                        );
//
//            });
//        }
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

//        appExecutors.shutdown();
    }
}