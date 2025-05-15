package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.software.diploma.webapplicationforsellingcableandwireproducts.controller.user")
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundException> userNotFoundExceptionHandler(
            UserNotFoundException exception
    ) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserBannedException.class)
    public ResponseEntity<UserBannedException> userBannedExceptionHandler(
            UserBannedException exception
    ) {
        return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
    }
}
