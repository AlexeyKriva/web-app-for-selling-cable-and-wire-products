package com.software.diploma.webapplicationforsellingcableandwireproducts.event.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CartUpdateEvent extends ApplicationEvent {
    private CartProduct cartProduct;
    private Integer deltaCartProductCount;
    private CartEventStatus status;

    public CartUpdateEvent(Object source, CartProduct cartProduct, Integer deltaCartProductCount, CartEventStatus status) {
        super(source);
        this.cartProduct = cartProduct;
        this.deltaCartProductCount = deltaCartProductCount;
        this.status = status;
    }
}
