package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Category;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.CategoryNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.CategoryRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.CATEGORY_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND_MESSAGE));
    }

    @Transactional
    public Category save(Category category) {
        return repository.save(category);
    }

    @Transactional
    public Category updateById(long id, Category category) {
        Category existCategory = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND_MESSAGE));

        existCategory.setName(category.getName());

        return repository.save(existCategory);
    }
}
