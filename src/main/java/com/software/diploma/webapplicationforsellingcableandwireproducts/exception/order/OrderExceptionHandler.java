package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.software.diploma.webapplicationforsellingcableandwireproducts.controller.order")
public class OrderExceptionHandler {
    @ExceptionHandler(OrderNotFoundMessage.class)
    public ResponseEntity<OrderNotFoundMessage> cartNotFoundExceptionHandler(
            OrderNotFoundMessage exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderAlreadyPaidException.class)
    public ResponseEntity<OrderAlreadyPaidException> orderAlreadyPaidExceptionHandler(
            OrderAlreadyPaidException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
