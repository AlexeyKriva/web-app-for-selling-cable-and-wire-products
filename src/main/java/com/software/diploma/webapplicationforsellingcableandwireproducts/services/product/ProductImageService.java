package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductImage;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> getAllByProductId(Long productId);
    ProductImage save(ProductImage productImage);
    void deleteById(Long id);
}
