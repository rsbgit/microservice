package com.microservice.rating.controller;

import com.microservice.rating.model.ProductRating;
import com.microservice.rating.service.ProductRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/rating")
public class ProductRatingController {

    private ProductRatingService productRatingService;

    @Autowired
    public ProductRatingController(ProductRatingService productRatingService) {
        this.productRatingService = productRatingService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Float> getAvgRatingByProductId(@PathVariable("productId") Long productId) {
       return ResponseEntity.ok(productRatingService.getProductRating(productId));
    }

    @PostMapping
    public ResponseEntity<ProductRating> rateProduct(@RequestBody ProductRating productRating) {
        return ResponseEntity.ok(productRatingService.rateProduct(productRating));
    }
}
