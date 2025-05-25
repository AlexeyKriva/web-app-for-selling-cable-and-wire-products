package com.software.diploma.webapplicationforsellingcableandwireproducts.event.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsDeltaDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.MaterialService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductDetailsService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.VIEW_PRODUCT_ONE_TIME;

@Component
@RequiredArgsConstructor
public class ProductEventListener {
    private final ProductDetailsService productDetailsService;
    private final ProductStatsService productStatsService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void saveProductEvent(SaveProductEvent event) {
        Product product = event.getProduct();

        productDetailsService.save(new ProductDetails(product));
        productStatsService.save(new ProductStats(product));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void productViewEvent(ProductViewEvent event) {
        productStatsService.updateByProductId(
                event.getProductId(),
                ProductStatsDeltaDto.builder()
                        .deltaViewCount(VIEW_PRODUCT_ONE_TIME)
                        .build());
    }
}
