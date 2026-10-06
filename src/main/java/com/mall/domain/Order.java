package com.mall.domain;

import com.mall.discount.DiscountStrategy;

import java.math.BigDecimal;

public class Order {

    private Long id;
    private User user;
    private Product product;
    private int quantity;
    private double totalAmount;

    private DiscountStrategy discountStrategy;

    public Order(Long id,
                 User user,
                 Product product,
                 int quantity,
                 DiscountStrategy discountStrategy) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "订单数量必须大于0"
            );
        }

        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.discountStrategy = discountStrategy;
        // 兼容前面课程中使用 double 的折扣策略和余额模型。
        double originalprice = product.getPrice()
                .multiply(BigDecimal.valueOf(quantity))
                .doubleValue();
        this.totalAmount = discountStrategy.calculate(originalprice) ;
    }

    public void submit() {

        product.reduceStock(quantity);

        user.pay(totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
