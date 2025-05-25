package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import jakarta.validation.constraints.NotNull;

public record ProductStatsStockQuantityDto(
        @NotNull
        Integer deltaStockQuantity
) {
}
