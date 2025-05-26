package com.software.diploma.webapplicationforsellingcableandwireproducts.event.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.product.ProductStatsDeltaDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartProductService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.*;

@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final CartProductService cartProductService;
    private final CartService cartService;
    private final ProductStatsService productStatsService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void cartUpdateLastUpdatedTime(OrderPaidEvent event) {
        long userId = event.getUserId();
        List<CartProduct> cartProducts = event.getCartProducts();

        for (CartProduct cartProduct: cartProducts) {
            productStatsService.updateByProductId(
                    cartProduct.getProduct().getId(),
                    ProductStatsDeltaDto.builder()
                            .deltaCartCount(NEGATIVE_ONE * cartProduct.getTotalProductAmount())
                            .deltaSoldCount(cartProduct.getTotalProductAmount())
                            .deltaStockQuantity(NEGATIVE_ONE * cartProduct.getTotalProductAmount())
                            .build()
            );
        }

        Cart cart = cartService.getByUserId(userId);

        cart.getCartProducts().clear();
    }
}
