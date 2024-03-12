package com.example.demoshop.infrasrtucture.repositoty;


import com.example.demoshop.domain.entity.Category;
import com.example.demoshop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByCategory(Category category);
    // Другие методы запросов могут быть добавлены здесь
}