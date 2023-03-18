package com.cloudtech.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudtech.product.model.Product;
import com.cloudtech.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(String productName, Long userId, Double price, String description) {
        Product product = new Product();
        product.setProductName(productName);
        product.setUserId(userId);
        product.setPrice(price);
        product.setDescription(description);
        return productRepository.save(product);
    }

    public Optional<Product> deleteProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product productToDelete = optionalProduct.get();
            productRepository.deleteById(id);
            return Optional.of(productToDelete);
        } else {
            return Optional.empty();
        }
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

}
