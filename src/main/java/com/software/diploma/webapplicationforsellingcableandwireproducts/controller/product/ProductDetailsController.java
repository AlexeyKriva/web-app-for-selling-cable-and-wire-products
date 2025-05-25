package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductDetailsUpdateDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.ProductDetailsMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product-details", produces = "application/json")
@RequiredArgsConstructor
public class ProductDetailsController {
    private final ProductDetailsService service;

    private final ProductDetailsMapper mapper = ProductDetailsMapper.INSTANCE;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetails> getByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(service.getByProductId(productId));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDetails> updateByProductId(@PathVariable("productId") Long productId,
                                                            @Valid @RequestBody ProductDetailsUpdateDto updateDto) {
        return ResponseEntity.ok(service.updateByProductId(productId, mapper.toProductDetails(updateDto)));
    }
}

