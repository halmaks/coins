package com.halmaks.coins.controller;


import com.halmaks.coins.exception.ResourceNotFoundException;
import com.halmaks.coins.model.Product;
import com.halmaks.coins.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProduct() { return productRepository.findAll();}

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer productId)
        throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product) { return productRepository.save(product); }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @Valid @RequestBody Product productDetails)
        throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Integer productId)
        throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
