package com.example.demoshop.application.cart;

import com.example.demoshop.domain.entity.Cart;
import com.example.demoshop.presentation.exceptions.EntityNotFoundException;
import com.example.demoshop.infrasrtucture.repositoty.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository repository;

    public List<Cart> getAll() {
        return repository.findAll();
    }

    public Cart getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " not found"));    }

    public Cart create(Cart cartFromCommand)
    {
        return repository.save(cartFromCommand);
    }

    public Cart update(Long id, Cart cartFromCommand) {
        Cart cart = getById(id);


        return repository.save(cart);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
