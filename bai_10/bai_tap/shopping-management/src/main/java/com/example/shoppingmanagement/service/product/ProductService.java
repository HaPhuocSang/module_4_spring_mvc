package com.example.shoppingmanagement.service.product;

import com.example.shoppingmanagement.converter.ProductToProductDtoConverter;
import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final ProductToProductDtoConverter productToProductDtoConverter;
    public ProductService(IProductRepository productRepository, ProductToProductDtoConverter productToProductDtoConverter) {
        this.productRepository = productRepository;
        this.productToProductDtoConverter = productToProductDtoConverter;
    }

    @Override
    public Page<ProductDto> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable).map(productToProductDtoConverter::convert);
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(productToProductDtoConverter::convert);
    }
}
