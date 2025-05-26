package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderUpdateStatusDto(
        @NotNull
        OrderStatus status
) {
}
