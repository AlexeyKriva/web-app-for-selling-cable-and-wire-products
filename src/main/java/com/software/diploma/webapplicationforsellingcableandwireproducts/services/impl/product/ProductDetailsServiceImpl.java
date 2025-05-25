package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.product.ProductViewEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.ProductNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.ProductDetailsRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.CategoryService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.MaterialService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.PRODUCT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private final ProductDetailsRepository repository;
    private final CategoryService categoryService;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public ProductDetails getByProductId(Long productId) {
        ProductDetails productDetailsFromDb = repository.findByProductIdAndProductNotDeleted(productId)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });

        publisher.publishEvent(new ProductViewEvent(this, productId));

        return productDetailsFromDb;
    }

    @Transactional
    public ProductDetails save(ProductDetails productDetails) {
        return repository.save(productDetails);
    }

    @Transactional
    public ProductDetails updateByProductId(Long productId, ProductDetails updatedProductDetails) {
        ProductDetails existProductDetails = repository.findByProductIdAndProductNotDeleted(productId)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });

        if (updatedProductDetails.getDescription() != null) {
            existProductDetails.setDescription(updatedProductDetails.getDescription());
        }

        if (updatedProductDetails.getAnufacturer() != null) {
            existProductDetails.setAnufacturer(updatedProductDetails.getAnufacturer());
        }

        if (updatedProductDetails.getCategory().getId() != null) {
            existProductDetails.setCategory(categoryService.getById(updatedProductDetails.getCategory().getId()));
        }

        if (updatedProductDetails.getMaterials() != null) {
            List<Material> materials = updatedProductDetails.getMaterials().stream()
                    .map(material -> {
                        material.setProductDetails(existProductDetails);
                        return material;
                    })
                    .toList();

            existProductDetails.getMaterials().clear();
            existProductDetails.getMaterials().addAll(new ArrayList<>(materials));
        }

        return repository.save(existProductDetails);
    }
}
