package com.mall.service;

import com.mall.domain.Product;
import com.mall.dto.order.CreateOrderRequest;
import com.mall.dto.order.OrderResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private final ProductService productService;

    public OrderService(
            ProductService productService) {

        this.productService = productService;
    }

    public OrderResponse createOrder(
            CreateOrderRequest request) {

        validateRequest(request);

        Product product =
                productService.getProductById(
                        request.getProductId()
                );

        BigDecimal totalAmount =
                product.getPrice()
                        .multiply(
                                BigDecimal.valueOf(
                                        request.getQuantity()
                                )
                        );

        String orderNo =
                "ORD" + UUID.randomUUID().toString().replace("-", "");

        // 库存检查和扣减由 Product 在同一个同步方法中完成。
        product.reduceStock(request.getQuantity());

        return new OrderResponse(
                orderNo,
                request.getUserId(),
                request.getProductId(),
                request.getQuantity(),
                totalAmount,
                "CREATED"
        );
    }

    private void validateRequest(CreateOrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("下单请求不能为空");
        }
        if (request.getUserId() == null || request.getUserId() <= 0) {
            throw new IllegalArgumentException("用户ID必须大于0");
        }
        if (request.getProductId() == null || request.getProductId() <= 0) {
            throw new IllegalArgumentException("商品ID必须大于0");
        }
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("购买数量必须大于0");
        }
    }
}
