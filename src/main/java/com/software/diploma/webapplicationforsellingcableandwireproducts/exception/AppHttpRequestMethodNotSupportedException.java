package com.software.diploma.webapplicationforsellingcableandwireproducts.exception;

import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.lang.reflect.Method;
import java.util.Set;

@Getter
public class AppHttpRequestMethodNotSupportedException extends ApplicationException {
    private String method;
    private Object supportedMethods;

    public AppHttpRequestMethodNotSupportedException(String message, String method, Set<HttpMethod> supportedMethods) {
        super(message);
        this.method = method;
        this.supportedMethods = supportedMethods;
    }
}
