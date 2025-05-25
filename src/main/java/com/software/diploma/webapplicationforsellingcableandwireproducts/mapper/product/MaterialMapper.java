package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.MaterialDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);

    Material toMaterial(MaterialDto materialDto);

    Material toMaterialFromString(String name);
}
