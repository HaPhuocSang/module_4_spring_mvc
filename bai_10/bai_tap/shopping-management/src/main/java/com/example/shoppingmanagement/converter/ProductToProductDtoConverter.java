package com.example.shoppingmanagement.converter;

import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
