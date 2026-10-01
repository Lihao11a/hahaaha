package com.mall.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppExecutors {

    private final ThreadPoolExecutor notificationExecutor;

    public AppExecutors() {

        this.notificationExecutor =
                new ThreadPoolExecutor(
                        2,
                        4,
                        60,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10),
                        new ThreadPoolExecutor.CallerRunsPolicy()
                );
    }

    public ThreadPoolExecutor
    getNotificationExecutor() {

        return notificationExecutor;
    }

    public void shutdown() {

        notificationExecutor.shutdown();
    }
}