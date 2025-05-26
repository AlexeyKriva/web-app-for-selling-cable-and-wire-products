package com.software.diploma.webapplicationforsellingcableandwireproducts.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.METHOD_NOT_ALLOWED_MESSAGE;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<InsufficientStockException> insufficientStockExceptionHandler(
            InsufficientStockException exception
    ) {
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<DataAccessException> dataAccessExceptionHandler(DataAccessException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<AppHttpRequestMethodNotSupportedException> handleMethodNotAllowed(
            HttpRequestMethodNotSupportedException exception) {

        return new ResponseEntity<>(new AppHttpRequestMethodNotSupportedException(
                METHOD_NOT_ALLOWED_MESSAGE, exception.getMethod(), exception.getSupportedHttpMethods()
        ), HttpStatus.METHOD_NOT_ALLOWED);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Exception> genericExceptionHandler(Exception exception) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(exception);
//    }
}
