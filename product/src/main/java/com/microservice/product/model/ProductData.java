package com.microservice.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ProductData {
    private String name;
    private Double price;
    private Float rating;

    public ProductData(String name, Double price, Float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
