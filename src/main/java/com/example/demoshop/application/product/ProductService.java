package com.example.demoshop.application.product;


import com.example.demoshop.domain.entity.Category;
import com.example.demoshop.domain.entity.Product;
import com.example.demoshop.infrasrtucture.repositoty.ProductRepository;
import com.example.demoshop.presentation.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));    }

    public List<Product> getByCategory(Category category) {
        return repository.findByCategory(category);
    }
    public Product create(Product productFromCommand) {
        return repository.save(productFromCommand);
    }

    public Product update(Long id, Product productFromCommand) {
        Product product = getById(id);

        // Обновление полей продукта

        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}