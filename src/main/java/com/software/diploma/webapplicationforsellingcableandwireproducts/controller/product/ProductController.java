package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.ProductMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products", produces = "application/json")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody ProductSaveDto productDto) {
        return new ResponseEntity<>(service.save(mapper.toProduct(productDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
