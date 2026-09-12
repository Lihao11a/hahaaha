package com.mall.discount;

//任何想成为商城折扣策略的类，都必须拥有calculate能力
public interface DiscountStrategy {
    double calculate(double originalPrice);
}
