package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsStockQuantityDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductStatsMapper {
    ProductStatsMapper INSTANCE = Mappers.getMapper(ProductStatsMapper.class);

    @Mapping(target = "stockQuantity", source = "deltaStockQuantity")
    ProductStats toProductStats(ProductStatsStockQuantityDto productStatsDto);
}
