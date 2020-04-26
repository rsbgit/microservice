package com.microservice.product.service;

import com.microservice.product.model.ProductData;
import com.microservice.product.model.ProductDataBuilder;
import com.microservice.product.model.ProductEntity;
import com.microservice.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;

import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    RestOperations restTemplate;
    @Value("${rest.endpoint.ratingservice.avgrating}")
    private String avgRatingServiceUrl;

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

    public ProductData getProductDataById(Long id) {
        ProductEntity savedProduct = getProductById(id);
        return new ProductDataBuilder()
                .setName(savedProduct.getName())
                .setPrice(savedProduct.getPrice())
                .setRating(getAvgRating(savedProduct.getId())).createProductData();
    }

    private Float getAvgRating(Long productId) {
        System.out.println(avgRatingServiceUrl+"/"+productId);
        return restTemplate.getForObject(avgRatingServiceUrl+"/"+productId, Float.class);
    }
}
