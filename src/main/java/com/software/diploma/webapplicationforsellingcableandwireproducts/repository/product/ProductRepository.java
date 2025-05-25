package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIdAndIsDeletedFalse(Long id);
    Page<Product> findByIsDeletedFalse(Pageable pageable);
}
