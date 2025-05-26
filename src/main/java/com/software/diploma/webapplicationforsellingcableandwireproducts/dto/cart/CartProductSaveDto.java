package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartProductSaveDto(
        @NotNull
        Long cartId,

        @NotNull
        Long productId,

        @NotNull
        @Min(value = 1)
        Integer totalProductAmount
) {
}
