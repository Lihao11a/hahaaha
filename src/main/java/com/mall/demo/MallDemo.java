package com.mall.demo;

import com.mall.domain.Product;
import com.mall.repository.ProductCatalog;
import com.mall.repository.ProductFileRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class MallDemo {

    public static void main(String[] args) {

        ProductFileRepository fileRepository =
                new ProductFileRepository(
                        Path.of(
                                "data",
                                "products.csv"
                        )
                );


        ProductCatalog catalog =
                new ProductCatalog();

        try {

            List<Product> products =
                    fileRepository.loadProducts();

            for (Product product : products) {

                catalog.add(product);

            }

            System.out.println(
                    "商品加载成功，共 "
                            + catalog.size()
                            + " 件商品"
            );

            Product product =
                    catalog.findById(1002L);

            System.out.println(
                    "查询结果："
                            + product.getName()
            );

        } catch (IOException e) {

            System.err.println(
                    "商品文件读取失败："
                            + e.getMessage()
            );

        }
    }
}