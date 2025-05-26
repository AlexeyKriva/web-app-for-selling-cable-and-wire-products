package com.software.diploma.webapplicationforsellingcableandwireproducts.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalConstants {
    public static final Integer DEFAULT_INTEGER_VALUE = 0;
    public static final Integer DEFAULT_NEGATIVE = -1;
    public static final Long VIEW_PRODUCT_ONE_TIME = 1L;
    public static final String INSUFFICIENT_STOCK_MESSAGE = "Requested quantity exceeds available stock.";
    public static final Integer MIN_TOTAL_PRODUCT_AMOUNT_IN_CART = 0;
}
