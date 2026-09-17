package com.mall.exception;

public class ProductNotFoundException extends BusinessException{
    public ProductNotFoundException(Long productId) {
        super("商品不存在，productId=" + productId);
    }
}
