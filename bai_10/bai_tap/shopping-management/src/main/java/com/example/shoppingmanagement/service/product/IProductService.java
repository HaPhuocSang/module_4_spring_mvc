package com.example.shoppingmanagement.service.product;

import com.example.shoppingmanagement.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IProductService {
    Page<ProductDto> findAll(Integer page, Integer size);
    Optional<ProductDto> findById(Long id);
}
