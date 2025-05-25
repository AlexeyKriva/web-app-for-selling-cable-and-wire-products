package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
