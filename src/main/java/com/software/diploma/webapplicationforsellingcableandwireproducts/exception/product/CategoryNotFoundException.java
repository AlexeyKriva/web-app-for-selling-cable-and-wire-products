package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class CategoryNotFoundException extends ApplicationException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
