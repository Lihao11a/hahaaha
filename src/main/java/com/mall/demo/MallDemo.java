package com.mall.demo;

import com.mall.domain.Order;
import com.mall.domain.Product;
import com.mall.domain.User;

public class MallDemo {
    public static void main(String[] args) {
        User user =
                new User(
                        1001L,
                        "小明",
                        1000
                );

        Product product =
                new Product(
                        2001L,
                        "机械键盘",
                        299,
                        10
                );



        Order order =
                new Order(
                        3001L,
                        user,
                        product,
                        2
                );

        order.submit();

        System.out.println(
                "剩余余额：" +
                        user.getBalance()
        );

        System.out.println(
                "剩余库存：" +
                        product.getStock()
        );
    }
}

