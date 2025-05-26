package com.software.diploma.webapplicationforsellingcableandwireproducts.util.cart;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartExceptionMessage {
    public static final String CART_PRODUCT_NOT_FOUND_MESSAGE = "This product is not in the cart.";
    public static final String CART_NOT_FOUND_MESSAGE = "Cart not found.";
    public static final String INVALID_QUANTITY_MESSAGE = "Cannot remove more items than are currently in the cart.";
}
