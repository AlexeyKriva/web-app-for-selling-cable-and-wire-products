package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsStockQuantityDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.ProductStatsMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product-stats", produces = "application/json")
@RequiredArgsConstructor
public class ProductStatsController {
    private final ProductStatsService service;
    private final ProductStatsMapper mapper = ProductStatsMapper.INSTANCE;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductStats> getByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(service.getByProductId(productId));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<ProductStats> updateStockQuantityByProductId(
            @PathVariable("productId") Long productId,
            @Valid @RequestBody ProductStatsStockQuantityDto productStatsStockQuantityDto
            ) {
        return ResponseEntity.ok(service.updateStockQuantityByProductId(productId,
                mapper.toProductStats(productStatsStockQuantityDto)));
    }
}
