package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
