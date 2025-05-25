package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(long id);
    Category save(Category category);
    Category updateById(long id, Category category);
}
