package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.CategoryDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Category;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product.CategoryMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = "application/json")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    private final CategoryMapper mapper = CategoryMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(service.save(mapper.toCategory(categoryDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateById(
            @PathVariable("id") Long id,
            @Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(service.updateById(id, mapper.toCategory(categoryDto)));
    }
}
