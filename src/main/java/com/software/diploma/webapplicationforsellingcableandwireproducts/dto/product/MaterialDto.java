package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MaterialDto(
        @NotNull
        Long productId,

        @Size(max = 255)
        @NotBlank
        String name
)
{ }
