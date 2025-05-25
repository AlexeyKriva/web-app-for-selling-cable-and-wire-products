package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductImageDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductImageMapper {
    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    @Mapping(target = "url", source = "url")
    ProductImage toProductImage(ProductImageDto imageDto);
}
