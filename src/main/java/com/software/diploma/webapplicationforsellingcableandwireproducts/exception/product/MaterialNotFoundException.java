package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class MaterialNotFoundException extends ApplicationException {
    public MaterialNotFoundException(String message) {
        super(message);
    }
}
