package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.MaterialDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.MaterialMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/materials", produces = "application/json")
@RequiredArgsConstructor
public class MaterialController {
    private final MaterialService service;
    private final MaterialMapper mapper = MaterialMapper.INSTANCE;

    @GetMapping("/product-details/{productDetailsId}")
    public ResponseEntity<List<Material>> getAllByProductDetailsId(@PathVariable Long productDetailsId) {
        return ResponseEntity.ok(service.getAllByProductDetailsId(productDetailsId));
    }

    @PostMapping
    public ResponseEntity<Material> save(@Valid @RequestBody MaterialDto materialDto) {
        return new ResponseEntity<>(service.save(mapper.toMaterial(materialDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
