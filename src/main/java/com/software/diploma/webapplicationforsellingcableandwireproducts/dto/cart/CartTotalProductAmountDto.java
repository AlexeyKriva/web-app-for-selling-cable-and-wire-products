package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart;

import jakarta.validation.constraints.NotNull;

public record CartTotalProductAmountDto(
        @NotNull
        Integer deltaTotalProductAmount
) {
}
