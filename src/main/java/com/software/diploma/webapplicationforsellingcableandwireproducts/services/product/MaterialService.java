package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAllByProductDetailsId(Long productId);
    Material save(Material material);
    void deleteById(Long id);
}
