package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;

public class OrderNotFoundMessage extends ApplicationException {
    public OrderNotFoundMessage(String message) {
        super(message);
    }
}
