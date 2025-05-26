package com.software.diploma.webapplicationforsellingcableandwireproducts.util.order;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderExceptionMessage {
    public static final String ORDER_NOT_FOUND_MESSAGE = "Order not found.";
    public static final String ORDER_ALREADY_PAID_MESSAGE = "Order already paid.";

}
