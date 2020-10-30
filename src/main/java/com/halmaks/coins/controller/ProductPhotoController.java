package com.halmaks.coins.controller;

import com.halmaks.coins.model.ProductPhoto;
import com.halmaks.coins.repository.ProductPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductPhotoController {
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @GetMapping("/product-photo")
    public List<ProductPhoto> getAllProductPhoto() {
        return productPhotoRepository.findAll();
    }

    @PostMapping("product-photo")
    public ProductPhoto createProductPhoto(@Valid @RequestBody ProductPhoto productPhoto) {
        return productPhotoRepository.save(productPhoto);
    }
}
