package org.example.bai_tap.service;

import org.example.bai_tap.enity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private final static Map<Integer,Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "iPhone 15", 20000000.0, "Điện thoại Apple iPhone 15", "Apple"));
        productMap.put(2, new Product(2, "Samsung Galaxy S24", 18000000.0, "Điện thoại Samsung Galaxy S24", "Samsung"));
        productMap.put(3, new Product(3, "Xiaomi 14", 15000000.0, "Điện thoại Xiaomi 14", "Xiaomi"));
        productMap.put(4, new Product(4, "OPPO Reno 11", 10000000.0, "Điện thoại OPPO Reno 11", "OPPO"));
        productMap.put(5, new Product(5, "iPhone 14", 16000000.0, "Điện thoại Apple iPhone 14", "Apple"));
    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public List<Product> findProductByName(String productName) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (entry.getValue().getProductName().trim().toLowerCase().contains(productName.trim().toLowerCase())) {
                productList.add(entry.getValue());
            }
        }
        return productList;
    }

    @Override
    public boolean addProduct(Product product) {
        int newId = 1;
        for (Integer key : productMap.keySet()) {
            if (key >= newId) {
                newId = key;
            }
        }
        newId++;
        product.setId(newId);
        productMap.put(newId, product);
        return true;
    }

    @Override
    public Product findProductById(Integer productId) {
        if (productMap.get(productId) != null) {
            return productMap.get(productId);
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        Integer key = product.getId();
        if (productMap.containsKey(key)) {
            productMap.put(key, product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        if (productMap.containsKey(productId)) {
            productMap.remove(productId);
            return true;
        }
        return false;
    }
}
