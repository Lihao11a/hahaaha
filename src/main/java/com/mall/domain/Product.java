package com.mall.domain;

import com.mall.exception.InsufficientStockException;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private int stock;

    public Product(Long id,
                   String name,
                   double price,
                   int stock) {
        this(id, name, BigDecimal.valueOf(price), stock);
    }

    public Product(Long id,
                   String name,
                   BigDecimal price,
                   int stock) {

        if (price == null || price.signum() < 0) {
            throw new IllegalArgumentException(
                    "商品价格不能为空或小于0"
            );
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                    "商品库存不能小于0"
            );
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public synchronized void reduceStock(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("购买数量必须大于0");
        }

        if (stock < quantity) {

            throw new InsufficientStockException(
                    id,
                    stock,
                    quantity
            );

        }
        try{
            Thread.sleep(100);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        stock = stock - quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
