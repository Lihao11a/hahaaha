package com.mall.domain;

public class Order {

    private Long id;
    private User user;
    private Product product;
    private int quantity;
    private double totalAmount;

    public Order(Long id,
                 User user,
                 Product product,
                 int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "订单数量必须大于0"
            );
        }

        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;

        this.totalAmount =
                product.getPrice() * quantity;
    }

    public void submit() {

        product.reduceStock(quantity);

        user.pay(totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}