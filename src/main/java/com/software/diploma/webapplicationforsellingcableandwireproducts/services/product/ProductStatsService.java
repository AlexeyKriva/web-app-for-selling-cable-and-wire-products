package com.software.diploma.webapplicationforsellingcableandwireproducts.services.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsDeltaDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;

public interface ProductStatsService {
    ProductStats getByProductId(Long productId);
    ProductStats save(ProductStats productStats);
    ProductStats updateByProductId(Long productId, ProductStatsDeltaDto productStatsDeltaDto);
    ProductStats updateStockQuantityByProductId(Long productId, ProductStats productStats);
}
