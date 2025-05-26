package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class CartNotFoundException extends ApplicationException {
    public CartNotFoundException(String message) {
        super(message);
    }
}
