package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import lombok.Builder;

@Builder
public record ProductStatsDeltaDto(
    Integer deltaStockQuantity,
    Integer deltaSoldCount,
    Integer deltaCartCount,
    Long deltaViewCount
) { }
