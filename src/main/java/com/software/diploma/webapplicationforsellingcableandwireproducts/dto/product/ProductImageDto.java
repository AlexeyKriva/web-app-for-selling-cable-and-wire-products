package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public record ProductImageDto(
        @NotNull
        Long productId,

        @URL
        @NotBlank
        String url
) { }
