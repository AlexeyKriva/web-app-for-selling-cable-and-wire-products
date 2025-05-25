package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsDeltaDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.ProductNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.ProductStatsRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.PRODUCT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class ProductStatsServiceImpl implements ProductStatsService {
    private final ProductStatsRepository repository;

    @Transactional(readOnly = true)
    public ProductStats getByProductId(Long productId) {
        return repository.findByProductIdAndProductNotDeleted(productId)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });
    }

    @Transactional
    public ProductStats save(ProductStats productStats) {
        return repository.save(productStats);
    }

    @Transactional
    public ProductStats updateByProductId(Long productId, ProductStatsDeltaDto productStatsDeltaDto) {
        ProductStats existProductStats = repository.findByProductIdAndProductNotDeleted(productId)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });

        if (productStatsDeltaDto.deltaStockQuantity() != null) {
            existProductStats.setStockQuantity(existProductStats.getStockQuantity() +
                    productStatsDeltaDto.deltaStockQuantity());
        }

        if (productStatsDeltaDto.deltaSoldCount() != null) {
            existProductStats.setSoldCount(existProductStats.getSoldCount() +
                    productStatsDeltaDto.deltaSoldCount());
        }

        if (productStatsDeltaDto.deltaCartCount() != null) {
            existProductStats.setCartCount(existProductStats.getCartCount() +
                    productStatsDeltaDto.deltaCartCount());
        }

        if (productStatsDeltaDto.deltaViewCount() != null) {
            existProductStats.setViewCount(existProductStats.getViewCount() +
                    productStatsDeltaDto.deltaViewCount());
        }

        return repository.save(existProductStats);
    }

    @Transactional
    public ProductStats updateStockQuantityByProductId(Long productId, ProductStats productStats) {
        ProductStats productStatsFromDb = repository.findByProductIdAndProductNotDeleted(productId)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });

        productStatsFromDb.setStockQuantity(productStatsFromDb.getStockQuantity() +
                productStats.getStockQuantity());

        return repository.save(productStatsFromDb);
    }
}
