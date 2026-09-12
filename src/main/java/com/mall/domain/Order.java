package com.mall.domain;

import com.mall.discount.DiscountStrategy;

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
        double originalprice = product.getPrice() * quantity;
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