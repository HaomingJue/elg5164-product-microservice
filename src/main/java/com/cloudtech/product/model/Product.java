package com.cloudtech.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Long userId;
    private Double price;
    private String description;
}
