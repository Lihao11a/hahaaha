package com.mall.discount;

public class NormalDiscount implements DiscountStrategy{
    @Override
    public double calculate(double originalprice){
        return originalprice;
    }
}
