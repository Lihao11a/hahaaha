package com.mall.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mall.domain.Product;
import com.mall.exception.ProductNotFoundException;

@Repository
public class ProductCatalog {

    private final Map<Long, Product> products = new HashMap<>();

    public ProductCatalog(ProductFileRepository productFileRepository)
            throws IOException {

        // 创建商品目录时，读取 CSV 并放入内存。
        for (Product product : productFileRepository.loadProducts()) {
            add(product);
        }
    }

    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("商品不能为空");
        }
        products.put(product.getId(), product);
    }

    public Product findById(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public void remove(Long id) {
        products.remove(id);
    }

    public int size() {
        return products.size();
    }
}