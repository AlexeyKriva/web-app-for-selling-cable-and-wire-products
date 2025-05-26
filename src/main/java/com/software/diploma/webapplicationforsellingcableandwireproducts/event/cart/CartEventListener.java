package com.software.diploma.webapplicationforsellingcableandwireproducts.event.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsDeltaDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart.CartProductQuantityExceededException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart.CartProductRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartEventListener {
    private final CartService cartService;
    private final ProductStatsService productStatsService;

    @EventListener
    public void cartUpdateLastUpdatedTime(CartUpdateEvent event) {
        CartProduct cartProduct = event.getCartProduct();
        int deltaCartProductCount = event.getDeltaCartProductCount();
        CartEventStatus status = event.getStatus();

        cartService.updateLastUpdatedAt(cartProduct.getCart().getId());
        productStatsService.updateByProductId(cartProduct.getProduct().getId(), ProductStatsDeltaDto.builder()
                .deltaCartCount(status.getValue() * deltaCartProductCount)
                .build());
    }
}
