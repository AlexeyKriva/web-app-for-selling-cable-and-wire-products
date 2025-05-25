package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.CategoryDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryDto categoryDto);
}
