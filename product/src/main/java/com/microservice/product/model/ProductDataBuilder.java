package com.microservice.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDataBuilder {
    private String name;
    private Double price;
    private Float rating;

    public ProductDataBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductDataBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public ProductDataBuilder setRating(Float rating) {
        this.rating = rating;
        return this;
    }

    public ProductData createProductData() {
        return new ProductData(name, price, rating);
    }
}