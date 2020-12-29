package com.halmaks.coins.controller;

import com.halmaks.coins.exception.ResourceNotFoundException;
import com.halmaks.coins.model.CartProduct;
import com.halmaks.coins.repository.CartProductRepository;
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
public class CartProductController {

    @Autowired
    CartProductRepository cartProductRepository;

    @GetMapping("/cart-product")
    public List<CartProduct> getAllCartProduct() { return cartProductRepository.findAll(); }

    @GetMapping("/cart-product/{id}")
    public ResponseEntity<CartProduct> getCartProductById(@PathVariable(value = "id") Integer cartProductId)
            throws ResourceNotFoundException {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart Product not found for this id :: " + cartProductId));
        return ResponseEntity.ok().body(cartProduct);
    }

    @PostMapping("/cart-product")
    public CartProduct createCartProduct(@Valid @RequestBody CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    @PutMapping("/cart-product/{id}")
    public ResponseEntity<CartProduct> updateCartProduct(@PathVariable(value = "id") Integer cartProductId,
                                                   @Valid @RequestBody CartProduct cartProductDetails) throws ResourceNotFoundException {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart Product not found for this id :: " + cartProductId));

        cartProduct.setCartId(cartProductDetails.getCartId());
        cartProduct.setProductId(cartProductDetails.getProductId());
        final CartProduct updatedCartProduct = cartProductRepository.save(cartProduct);
        return ResponseEntity.ok(updatedCartProduct);
    }

    @DeleteMapping("/cart-product/{id}")
    public Map<String, Boolean> deleteCartProduct(@PathVariable(value = "id") Integer cartProductId)
            throws ResourceNotFoundException {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart Product not found for this id :: " + cartProductId));

        cartProductRepository.delete(cartProduct);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
