package com.mall.exception;

public class InsufficientStockException extends BusinessException{
    public InsufficientStockException( Long productId,int stock, int quantity){
        super( "库存不足，productId="
                + productId
                + "，当前库存="
                + stock
                + "，购买数量="
                + quantity);
    }
}
