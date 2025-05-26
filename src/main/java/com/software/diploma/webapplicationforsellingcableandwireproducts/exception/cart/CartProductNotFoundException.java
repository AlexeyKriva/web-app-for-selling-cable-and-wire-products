package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class CartProductNotFoundException extends ApplicationException {
    public CartProductNotFoundException(String message) {
        super(message);
    }
}
