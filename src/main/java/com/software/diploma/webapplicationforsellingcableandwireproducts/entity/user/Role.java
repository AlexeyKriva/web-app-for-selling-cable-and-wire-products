package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("GUEST"), USER("USER"), ADMIN("ADMIN");

    private final String role;
}
