package com.software.diploma.webapplicationforsellingcableandwireproducts.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonIgnoreProperties({"cause", "stackTrace", "suppressed", "localizedMessage"})
public class ApplicationException extends RuntimeException {
    protected LocalDateTime timestamp;

    public ApplicationException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
    }
}
