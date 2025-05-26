package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    NEW("new"), CANCELLED("cancelled"), PAID("paid");

    private final String name;
}
