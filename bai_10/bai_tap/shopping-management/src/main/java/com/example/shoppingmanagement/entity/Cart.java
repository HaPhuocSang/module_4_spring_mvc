package com.example.shoppingmanagement.entity;

import com.example.shoppingmanagement.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Cart {
    private Map<ProductDto, Integer> productDtoMap =  new HashMap<>();

    public Cart() {
    }

    public Cart(Map<ProductDto, Integer> products) {
        this.productDtoMap = products;
    }

    private boolean checkItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            if (entry.getKey().getId().equals(productDto.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            if (entry.getKey().getId().equals(productDto.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto productDto) {
        if (!checkItemInCart(productDto)) {
            productDtoMap.put(productDto, 1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            Integer newQuantity = itemEntry.getValue() + 1;
            productDtoMap.put(itemEntry.getKey(), newQuantity);
        }
    }

    public void updateProduct(ProductDto productDto, Integer quantity) {
        Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
        if (itemEntry == null) {
            return;
        }
        if (quantity <= 0) {
            productDtoMap.remove(itemEntry.getKey());
        } else {
            productDtoMap.put(itemEntry.getKey(), quantity);
        }
    }

    public void increaseProduct(ProductDto productDto) {
        Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
        if (itemEntry != null) {
            productDtoMap.put(itemEntry.getKey(), itemEntry.getValue() + 1
            );
        }
    }

    public void decreaseProduct(ProductDto productDto) {
        Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
        if (itemEntry != null) {
            int quantity = itemEntry.getValue() - 1;
            if (quantity <= 0) {
                productDtoMap.remove(itemEntry.getKey());
            } else {
                productDtoMap.put(itemEntry.getKey(), quantity);
            }
        }
    }

    public void removeProduct(ProductDto productDto) {
        Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
        if (itemEntry != null) {
            productDtoMap.remove(itemEntry.getKey());
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return productDtoMap.size();
    }

    public Double countTotalPayment(){
        double payment = 0.0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            payment += (entry.getKey().getPrice() * entry.getValue());
        }
        return payment;
    }

    public void clearCart() {
        productDtoMap.clear();
    }
}
