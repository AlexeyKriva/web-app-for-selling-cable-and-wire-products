package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class OrderAlreadyPaidException extends ApplicationException {
    public OrderAlreadyPaidException(String message) {
        super(message);
    }
}
