package com.mall.dto.order;

import java.math.BigDecimal;

public class OrderResponse {

    private String orderNo;

    private Long userId;

    private Long productId;

    private Integer quantity;

    private BigDecimal totalAmount;

    private String status;

    public OrderResponse(
            String orderNo,
            Long userId,
            Long productId,
            Integer quantity,
            BigDecimal totalAmount,
            String status) {

        this.orderNo = orderNo;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }
}