package com.mall.discount;

public class VipDiscount implements DiscountStrategy{
    @Override
    public double calculate(double originalPrice){
        return originalPrice * 0.95;
    }
}
