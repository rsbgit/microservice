package com.microservice.rating.service;

import com.microservice.rating.model.ProductRating;
import com.microservice.rating.repository.ProductRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRatingService {
    private ProductRatingRepository productRatingRepository;

    @Autowired
    public ProductRatingService(ProductRatingRepository productRatingRepository) {
        this.productRatingRepository = productRatingRepository;
    }

    public ProductRating rateProduct(ProductRating productRating) {
       return productRatingRepository.save(productRating);
    }

    public Float getProductRating(Long productId) {
        return productRatingRepository.getAvgRatingByProductId(productId);
    }
}
