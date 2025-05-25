package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductDetailsUpdateDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MaterialMapper.class)
public interface ProductDetailsMapper {
    ProductDetailsMapper INSTANCE = Mappers.getMapper(ProductDetailsMapper.class);

    @Mapping(target = "product.name", source = "name")
    @Mapping(target = "product.mainImageUrl", source = "mainImageUrl")
    @Mapping(target = "product.priceBelRub", source = "priceBelRub")
    @Mapping(target = "product.discountPercentage", source = "discountPercentage")
    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "materials", source = "materials")
    ProductDetails toProductDetails(ProductDetailsUpdateDto updateDto);
}
