package com.mall.domain;

import com.mall.exception.InsufficientStockException;

public class Product {

    private Long id;
    private String name;
    private double price;
    private int stock;

    public Product(Long id,
                   String name,
                   double price,
                   int stock) {

        if (price < 0) {
            throw new IllegalArgumentException(
                    "商品价格不能小于0"
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

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}