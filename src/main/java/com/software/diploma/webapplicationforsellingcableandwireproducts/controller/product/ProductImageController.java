package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductImageDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductImage;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.ProductImageMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product-images", produces = "application/json")
@RequiredArgsConstructor
public class ProductImageController {
    private final ProductImageService service;
    private final ProductImageMapper mapper = ProductImageMapper.INSTANCE;

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductImage>> getAllByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(service.getAllByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<ProductImage> save(@Valid @RequestBody ProductImageDto imageDto) {
        return new ResponseEntity<>(service.save(mapper.toProductImage(imageDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
