package com.example.demoshop.presentation.product.dto.queries;

import lombok.Data;

@Data
public class ProductQuery {
    private Long id;
    private String name;
    private double price;
    private String categoryName;
}

