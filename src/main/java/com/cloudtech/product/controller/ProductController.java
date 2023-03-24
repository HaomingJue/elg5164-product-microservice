package com.cloudtech.product.controller;

import java.util.List;
import java.util.Optional;

import com.cloudtech.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloudtech.product.model.Product;
import com.cloudtech.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello from product";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> optionalProduct = productService.getProductById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        Product savedProduct = productService.createProduct(productRequest.getProductName(),
                productRequest.getUserId(),
                productRequest.getPrice(),
                productRequest.getDescription());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id) {
        Optional<Product> optionalProduct = productService.deleteProductById(id);

        if (optionalProduct.isPresent()) {
            Product deletedProduct = optionalProduct.get();
            return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllProducts() {
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
