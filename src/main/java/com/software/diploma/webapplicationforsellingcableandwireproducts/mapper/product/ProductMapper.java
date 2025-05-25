package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductSaveDto productDto);
}
