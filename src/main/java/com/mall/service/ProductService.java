package com.mall.service;

import com.mall.repository.ProductFileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductFileRepository productFileRepository;

    public ProductService(ProductFileRepository productFileRepository){
        this.productFileRepository =  productFileRepository;
    }
}
