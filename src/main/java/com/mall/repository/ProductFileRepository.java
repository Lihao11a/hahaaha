package com.mall.repository;

import com.mall.domain.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductFileRepository {

    private final Path filePath;

    public ProductFileRepository(@Value("${mall.product-file-path}") String filePath) {
        this.filePath = Path.of(filePath);
    }

    public List<Product> loadProducts()
            throws IOException {

        List<String> lines =
                Files.readAllLines(
                        filePath,
                        StandardCharsets.UTF_8
                );

        List<Product> products =
                new ArrayList<>();

        for (String line : lines) {

            if (line == null ||
                    line.isBlank()) {
                continue;
            }

            Product product =
                    parseProduct(line);

            products.add(product);
        }

        return products;
    }

    private Product parseProduct(
            String line) {

        String[] parts =
                line.split(",");

        if (parts.length != 4) {
            throw new IllegalArgumentException(
                    "商品数据格式错误：" + line
            );
        }

        Long id =
                Long.parseLong(
                        parts[0].trim()
                );

        String name =
                parts[1].trim();

        BigDecimal price =
                new BigDecimal(
                        parts[2].trim()
                );

        int stock =
                Integer.parseInt(
                        parts[3].trim()
                );

        return new Product(
                id,
                name,
                price,
                stock
        );
    }
}
