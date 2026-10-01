package com.mall.demo;

import com.mall.domain.Product;

public class ConcurrencyDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Product product =
                new Product(
                        1001L,
                        "机械键盘",
                        299.00,
                        1
                );

        Runnable buyTask = () -> {

            try {

                product.reduceStock(1);

                System.out.println(
                        Thread.currentThread().getName()
                                + "：购买成功"
                );

            } catch (Exception e) {

                System.out.println(
                        Thread.currentThread().getName()
                                + "：购买失败，"
                                + e.getMessage()
                );

            }

        };

        Thread userA =
                new Thread(
                        buyTask,
                        "用户A"
                );

        Thread userB =
                new Thread(
                        buyTask,
                        "用户B"
                );

        userA.start();
        userB.start();

        userA.join();
        userB.join();

        System.out.println(
                "最终库存："
                        + product.getStock()
        );

    }
}