package com.mall;

import com.mall.domain.Order;
import com.mall.domain.Product;
import com.mall.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MallBackendApplication {

    public static void main(String[] args) {
        User user = new User(1001L,"小李",1000);

        Product product = new Product(2001L,"机械键盘",299,10);

        Order order = new Order(3001L,user,product,2);
        System.out.println(
                "下单前余额：" +
                        user.getBalance()
        );

        System.out.println(
                "下单前库存：" +
                        product.getStock()
        );

        order.submit();

        System.out.println("购买后余额" +
                user.getBalance());

        System.out.println("购买后库存" + product.getStock());





//        SpringApplication.run(MallBackendApplication.class, args);
    }

}
