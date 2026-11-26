package com.example.shoppingmanagement.converter;

import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getDescription());
    }
}
