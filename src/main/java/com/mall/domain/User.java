package com.mall.domain;

import com.mall.exception.InsufficientBalanceException;

public class User {

    private Long id;
    private String username;
    private double balance;

    public User(Long id,
                String username,
                double balance) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "用户ID必须大于0"
            );
        }

        if (username == null ||
                username.isBlank()) {

            throw new IllegalArgumentException(
                    "用户名不能为空"
            );
        }

        if (balance < 0) {
            throw new IllegalArgumentException(
                    "初始余额不能小于0"
            );
        }

        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public void recharge(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "充值金额必须大于0"
            );
        }

        balance += amount;
    }

    public void pay(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "支付金额必须大于0"
            );
        }

        if (balance < amount) {
            throw new InsufficientBalanceException(id,balance,amount);
        }

        balance -= amount;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }
}