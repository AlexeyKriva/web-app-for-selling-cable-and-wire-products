package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;

public interface ProductDetailsService {
    ProductDetails getByProductId(Long productId);
    ProductDetails save(ProductDetails productDetails);
    ProductDetails updateByProductId(Long productId, ProductDetails productDetails);
}
