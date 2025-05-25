package com.software.diploma.webapplicationforsellingcableandwireproducts.util.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductExceptionMessage {
    public static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found.";
    public static final String MATERIAL_NOT_FOUND_MESSAGE = "Material not found.";
    public static final String CATEGORY_NOT_FOUND_MESSAGE = "Category not found.";
    public static final String IMAGE_NOT_FOUND_MESSAGE = "Image not found.";
}
