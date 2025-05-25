package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDto (
        @NotBlank
        @Size(max = 255)
        String name
)
{ }
