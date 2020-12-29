package com.halmaks.coins.controller;

import com.halmaks.coins.exception.ResourceNotFoundException;
import com.halmaks.coins.model.ProductPhoto;
import com.halmaks.coins.repository.ProductPhotoRepository;
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
public class ProductPhotoController {
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @GetMapping("/product-photo")
    public List<ProductPhoto> getAllProductPhoto() {
        return productPhotoRepository.findAll();
    }

    @GetMapping("/product-photo/{id}")
    public ResponseEntity<ProductPhoto> getProductPhotoById(@PathVariable(value = "id") Integer productPhotoId)
            throws ResourceNotFoundException {
        ProductPhoto productPhoto = productPhotoRepository.findById(productPhotoId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Photo not found for this id:: " + productPhotoId));

        return ResponseEntity.ok().body(productPhoto);
    }

    @PostMapping("/product-photo")
    public ProductPhoto createProductPhoto(@Valid @RequestBody ProductPhoto productPhoto) {
        return productPhotoRepository.save(productPhoto);
    }

    @PutMapping("/product-photo/{id}")
    public ResponseEntity<ProductPhoto> updateProductPhoto(@PathVariable(value = "id") Integer productPhotoId,
                                                   @Valid @RequestBody ProductPhoto productPhotoDetails)
            throws ResourceNotFoundException {
        ProductPhoto productPhoto = productPhotoRepository.findById(productPhotoId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Photo not found for this id :: " + productPhotoId));

        productPhoto.setUrl(productPhotoDetails.getUrl());
        productPhoto.setProductId(productPhotoDetails.getProductId());
        final ProductPhoto updatedProductPhoto = productPhotoRepository.save(productPhoto);
        return ResponseEntity.ok(updatedProductPhoto);
    }

    @DeleteMapping("/product-photo/{id}")
    public Map<String, Boolean> deleteProductPhoto(@PathVariable(value = "id") Integer productPhotoId)
            throws ResourceNotFoundException {
        ProductPhoto productPhoto = productPhotoRepository.findById(productPhotoId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Photo not found for this id :: " + productPhotoId));

        productPhotoRepository.delete(productPhoto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
