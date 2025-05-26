package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderSaveDto (
        @NotNull
        Long userId,

        @NotBlank
        String deliveryAddress
) {
}
