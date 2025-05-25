package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class ProductNotFoundException extends ApplicationException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
