package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartProductMapper {
    CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);

    CartProduct toCartProduct(CartProductSaveDto cartProductSaveDto);
}
