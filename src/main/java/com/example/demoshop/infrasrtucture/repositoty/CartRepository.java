package com.example.demoshop.infrasrtucture.repositoty;

import com.example.demoshop.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);
    // Другие методы запросов могут быть добавлены здесь
}
