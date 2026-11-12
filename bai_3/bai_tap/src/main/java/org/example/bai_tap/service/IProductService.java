package org.example.bai_tap.service;

import org.example.bai_tap.enity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();

    List<Product> findProductByName(String productName);

    boolean addProduct(Product product);

    Product findProductById(Integer productId);

    boolean updateProduct(Product product);

    boolean deleteProduct(Integer productId);
}
