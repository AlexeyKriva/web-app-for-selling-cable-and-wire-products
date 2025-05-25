package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class ImageNotFoundException extends ApplicationException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
