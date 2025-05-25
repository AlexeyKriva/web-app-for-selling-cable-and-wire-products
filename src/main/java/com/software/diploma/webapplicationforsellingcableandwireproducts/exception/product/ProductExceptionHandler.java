package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.software.diploma.webapplicationforsellingcableandwireproducts.controller.product")
public class ProductExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundException> productNotFoundExceptionHandler(
            ProductNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<CategoryNotFoundException> categoryNotFoundExceptionHandler(
            CategoryNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<ImageNotFoundException> imageNotFoundExceptionHandler(
            ImageNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
