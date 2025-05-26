package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderProductMapper {
    OrderProductMapper INSTANCE = Mappers.getMapper(OrderProductMapper.class);

    @Mapping(target = "order", ignore = true)
    OrderProduct toOrderProduct(CartProduct cartProduct);

    List<OrderProduct> toOrderProducts(List<CartProduct> cartProducts);

    @Mapping(target = "cart", ignore = true)
    CartProduct toCartProduct(OrderProduct orderProduct);

    List<CartProduct> toCartProducts(List<OrderProduct> orderProducts);
}
