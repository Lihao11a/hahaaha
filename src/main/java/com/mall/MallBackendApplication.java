package com.mall;

import com.mall.service.NotificationService;
import com.mall.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MallBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner testNotification(
            NotificationService notificationService) {

        return args -> {
            notificationService
                    .sendOrderSuccess("U10001");

        };
    }
}
