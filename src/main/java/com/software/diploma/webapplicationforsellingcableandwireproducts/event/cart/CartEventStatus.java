package com.software.diploma.webapplicationforsellingcableandwireproducts.event.cart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CartEventStatus {
    DELETE_PRODUCTS("delete products", -1), ADD_PRODUCTS("add products", 1),
    UPDATE_PRODUCTS("update products", 1);

    private final String name;
    private final Integer value;
}
