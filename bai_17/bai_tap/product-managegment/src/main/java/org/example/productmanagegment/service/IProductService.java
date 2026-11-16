package org.example.productmanagegment.service;

import org.example.productmanagegment.dto.ProductDto;

import java.util.Optional;

public interface IProductService {
    Iterable<ProductDto> findAll();

    Optional<ProductDto> findById(Long id);

    boolean save(ProductDto productDto);

    boolean update(ProductDto productDto);

    boolean remove(Long id);
}
