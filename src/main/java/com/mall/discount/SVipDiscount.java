package com.mall.discount;

public class SVipDiscount implements DiscountStrategy{
    @Override
    public double calculate(double originalPrice){
        return originalPrice * 0.9;
    }
}
