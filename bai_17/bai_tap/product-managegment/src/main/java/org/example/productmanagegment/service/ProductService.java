package org.example.productmanagegment.service;

import org.example.productmanagegment.dto.ProductDto;
import org.example.productmanagegment.entity.Product;
import org.example.productmanagegment.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<ProductDto> findAll() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            productDtoList.add(changeProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return Optional.of(changeProductDto(product.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean save(ProductDto productDto) {
        if (productDto.getId() == null) {
            productRepository.save(changeProduct1(productDto));
            return true;
        }
        if (productRepository.findById(productDto.getId()).isPresent()) {
            return false;
        }
        productRepository.save(changeProduct2(productDto));
        return true;
    }

    @Override
    public boolean update(ProductDto productDto) {
        if (productRepository.findById(productDto.getId()).isPresent()) {
            productRepository.save(changeProduct1(productDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ProductDto changeProductDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getManufacturer());
    }

    private Product changeProduct1(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(),  productDto.getPrice(), productDto.getDescription(), productDto.getManufacturer());
    }

    private Product changeProduct2(ProductDto productDto) {
        return new Product(productDto.getName(),  productDto.getPrice(), productDto.getDescription(), productDto.getManufacturer());
    }
}
