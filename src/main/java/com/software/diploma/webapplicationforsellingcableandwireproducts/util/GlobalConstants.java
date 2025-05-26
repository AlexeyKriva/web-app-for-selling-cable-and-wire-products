package com.software.diploma.webapplicationforsellingcableandwireproducts.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalConstants {
    public static final Integer DEFAULT_INTEGER_VALUE = 0;
    public static final Integer FIRST_LIST_INDEX = 0;
    public static final Double DEFAULT_DOUBLE_VALUE = 0.0;
    public static final Integer NEGATIVE_ONE = -1;
    public static final Long VIEW_PRODUCT_ONE_TIME = 1L;
    public static final String INSUFFICIENT_STOCK_MESSAGE = "Requested quantity exceeds available stock.";
    public static final Integer MIN_TOTAL_PRODUCT_AMOUNT_IN_CART = 0;
    public static final Integer ONE_HUNDRED_PERCENT = 100;
    public static final Integer DEFAULT_DISCOUNT_NUMBER = 1;
    public static final String METHOD_NOT_ALLOWED_MESSAGE = "Method not allowed.";
}
