package com.mall.demo;

import com.mall.discount.DiscountStrategy;
import com.mall.discount.NormalDiscount;
import com.mall.discount.SVipDiscount;
import com.mall.discount.VipDiscount;
import com.mall.domain.Order;
import com.mall.domain.Product;
import com.mall.domain.User;
import com.mall.repository.ProductCatalog;

public class MallDemo {
    public static void main(String[] args) {
        ProductCatalog catalog =
                new ProductCatalog();

        Product keyboard =
                new Product(
                        1001L,
                        "机械键盘",
                        299,
                        10
                );

        Product mouse =
                new Product(
                        1002L,
                        "无线鼠标",
                        199,
                        20
                );

        Product monitor =
                new Product(
                        1003L,
                        "显示器",
                        1299,
                        5
                );
        User user =
                new User(
                        1001L,
                        "小明",
                        1000
                );

        catalog.add(keyboard);
        catalog.add(mouse);
        catalog.add(monitor);

        Product product = catalog.findById(1003L);
        System.out.println(product.getName());
        for(Product item : catalog.findAll()){
            System.out.println(item.getName());
        }
        System.out.println(catalog.size());
        catalog.remove(1003L);
        System.out.println(catalog.size());

//        DiscountStrategy SVipDiscountStrateggy = new SVipDiscount();
//
//        Order order =
//                new Order(
//                        3001L,
//                        user,
//                        keyboard,
//                        2,
//                        SVipDiscountStrateggy
//                );
//
//        order.submit();
//
//        System.out.println(
//                "剩余余额：" +
//                        user.getBalance()
//        );
//
//        System.out.println(
//                "剩余库存：" +
//                        keyboard.getStock()
//        );
    }
}

