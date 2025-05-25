package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product getById(long id);
    Page<Product> getAll(Pageable pageable);
    Product save(Product product);
    void deleteById(long id);
    boolean existsById(Long id);
}
