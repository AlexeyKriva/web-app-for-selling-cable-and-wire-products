package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.software.diploma.webapplicationforsellingcableandwireproducts.controller.cart")
public class CartExceptionHandler {
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<CartNotFoundException> cartNotFoundExceptionHandler(
            CartNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartProductNotFoundException.class)
    public ResponseEntity<CartProductNotFoundException> cartProductNotFoundExceptionHandler(
            CartProductNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartProductQuantityExceededException.class)
    public ResponseEntity<CartProductQuantityExceededException> cartProductQuantityExceededExceptionHandler(
            CartProductQuantityExceededException exception) {
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
