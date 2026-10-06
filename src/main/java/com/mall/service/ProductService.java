package com.mall.service;

import org.springframework.stereotype.Service;

import com.mall.domain.Product;
import com.mall.repository.ProductCatalog;

@Service
public class ProductService {

    private final ProductCatalog productCatalog;

    public ProductService(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Product getProductById(Long id) {
        return productCatalog.findById(id);
    }
}