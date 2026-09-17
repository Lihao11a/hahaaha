package com.mall.exception;

public class InsufficientBalanceException extends BusinessException{
    public InsufficientBalanceException(
            Long userId,
            double balance,
            double amount) {

        super(
                "余额不足，userId="
                        + userId
                        + "，当前余额="
                        + balance
                        + "，支付金额="
                        + amount
        );
    }
}
