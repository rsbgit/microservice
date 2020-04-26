package com.microservice.product.controller;

import com.microservice.product.model.ProductData;
import com.microservice.product.model.ProductEntity;
import com.microservice.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Long> saveProduct(@RequestBody ProductEntity productEntity) {
        Long id = productService.saveProduct(productEntity);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductEntity>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

  //  @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductData> getProductDetailsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductDataById(id));
    }
}
