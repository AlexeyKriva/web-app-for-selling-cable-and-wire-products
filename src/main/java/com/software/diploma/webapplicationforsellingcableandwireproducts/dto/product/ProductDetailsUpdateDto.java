package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.Set;

public record ProductDetailsUpdateDto (
        @Pattern(regexp = "^[a-zA-Z0-9_ ]+$")
        String name,

        @URL
        String mainImageUrl,

        @NonNull
        @DecimalMin(value = "0")
        BigDecimal priceBelRub,

        @DecimalMin(value = "0")
        @DecimalMax(value = "100")
        Integer discountPercentage,

        @Min(value = 0)
        Integer categoryId,

        String description,

        String anufacturer,

        Set<String> materials
) { }
