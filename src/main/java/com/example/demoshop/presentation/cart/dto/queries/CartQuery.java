package com.example.demoshop.presentation.cart.dto.queries;


import com.example.demoshop.presentation.product.dto.queries.ProductQuery;
import lombok.Data;

import java.util.List;

@Data
public class CartQuery {
    private Long id;
    private String userName;
    private List<ProductQuery> products;
}
