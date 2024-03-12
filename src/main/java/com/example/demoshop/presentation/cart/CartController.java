package com.example.demoshop.presentation.cart;

import com.example.demoshop.application.cart.CartService;
import com.example.demoshop.domain.entity.Cart;
import com.example.demoshop.presentation.cart.dto.commands.CreateCartCommand;
import com.example.demoshop.presentation.cart.dto.commands.UpdateCartCommand;
import com.example.demoshop.presentation.cart.dto.queries.CartQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
class CartController {

    private CartService cartService;
    private ModelMapper modelMapper;

    @GetMapping("/{cartId}")
    public CartQuery getCartById(@PathVariable Long cartId) {
        return modelMapper.map(cartService.getById(cartId), CartQuery.class);
    }

    @PostMapping
    public CartQuery createCart(@RequestBody CreateCartCommand command) {
        Cart cartFromCommand = modelMapper.map(command, Cart.class);

        Cart cart = cartService.create(cartFromCommand);

        return modelMapper.map(cart, CartQuery.class);
    }

    @PutMapping("/{cartId}")
    public CartQuery updateCart(@PathVariable Long cartId, @RequestBody UpdateCartCommand command) {
        Cart cartFromCommand = modelMapper.map(command, Cart.class);

        Cart cart = cartService.update(cartId, cartFromCommand);

        return modelMapper.map(cart, CartQuery.class);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartService.delete(cartId);
    }

//    @PostMapping("/{cartId}/addProduct")
//    public CartQuery addProductToCart(@PathVariable Long cartId, @RequestBody AddProductToCartCommand command) {
//        // Add product to cart logic
//    }
//
//    @PostMapping("/{cartId}/removeProduct")
//    public CartQuery removeProductFromCart(@PathVariable Long cartId, @RequestBody RemoveProductFromCartCommand command) {
//        // Remove product from cart logic
//    }
}
