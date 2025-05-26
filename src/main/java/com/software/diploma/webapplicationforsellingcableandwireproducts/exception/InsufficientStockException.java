package com.software.diploma.webapplicationforsellingcableandwireproducts.exception;

import lombok.Getter;

@Getter
public class InsufficientStockException extends ApplicationException {
    private Integer requested;
    private Integer available;

    public InsufficientStockException(String message, Integer requested, Integer available) {
        super(message);
        this.requested = requested;
        this.available = available;
    }
}
