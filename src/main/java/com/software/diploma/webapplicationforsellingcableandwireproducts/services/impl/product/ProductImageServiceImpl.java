package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductImage;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.ImageNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.ProductNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.ProductImageRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductImageService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.IMAGE_NOT_FOUND_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.PRODUCT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository repository;
    private final ProductService productService;

    @Transactional(readOnly = true)
    public List<ProductImage> getAllByProductId(Long productId) {
        return repository.findAllByProductId(productId);
    }

    @Transactional
    public ProductImage save(ProductImage productImage) {
        if (productService.existsById(productImage.getProductId())) {
            return repository.save(productImage);
        }

        throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
    }

    @Transactional
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return;
        }

        throw new ImageNotFoundException(IMAGE_NOT_FOUND_MESSAGE);
    }
}
