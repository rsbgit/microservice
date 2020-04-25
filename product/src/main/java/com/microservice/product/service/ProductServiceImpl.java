package com.microservice.product.service;

import com.microservice.product.model.ProductEntity;
import com.microservice.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    public Long saveProduct(ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public Iterable<ProductEntity> getProducts() {
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        return productEntities;
    }

    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> savedProduct = productRepository.findById(id);
        return savedProduct.get();
    }

}
