package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;
import lombok.Getter;


@Getter
public class CartProductQuantityExceededException extends ApplicationException {
    private Integer deltaTotalProductAmount;

    public CartProductQuantityExceededException(String message, int deltaTotalProductAmount) {
        super(message);
        this.deltaTotalProductAmount = deltaTotalProductAmount;
    }
}
