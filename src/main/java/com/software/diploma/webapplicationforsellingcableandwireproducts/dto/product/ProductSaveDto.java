package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public record ProductSaveDto(
        @NotBlank
        @Size(min = 1, max = 255)
        @Pattern(regexp = "^[a-zA-Z0-9_ ]+$")
        String name,

        @URL
        @NotBlank
        String mainImageUrl,

        @NonNull
        @DecimalMin(value = "0")
        BigDecimal priceBelRub,

        @DecimalMin(value = "0")
        @DecimalMax(value = "100")
        BigDecimal discountPercentage
) {
}
