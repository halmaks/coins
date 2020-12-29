package com.halmaks.coins.controller;

import com.halmaks.coins.exception.ResourceNotFoundException;
import com.halmaks.coins.model.Cart;
import com.halmaks.coins.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart")
    public List<Cart> getAllCart() { return cartRepository.findAll(); }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable(value = "id") Integer cartId)
            throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + cartId));
        return ResponseEntity.ok().body(cart);
    }

    @PostMapping("/cart")
    public Cart createCart(@Valid @RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable(value = "id") Integer cartId,
                                                   @Valid @RequestBody Cart cartDetails) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + cartId));

        cart.setCustomerId(cartDetails.getCustomerId());
        final Cart updatedCart = cartRepository.save(cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/cart/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer cartId)
            throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + cartId));

        cartRepository.delete(cart);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
