package com.mall.repository;

import com.mall.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {

    private final Map<Long, Product> products =
            new HashMap<>();

    public void add(Product product) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "商品不能为空"
            );
        }

        products.put(
                product.getId(),
                product
        );
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(
                products.values()
        );
    }

    public void remove(Long id) {
        products.remove(id);
    }

    public int size() {
        return products.size();
    }
}