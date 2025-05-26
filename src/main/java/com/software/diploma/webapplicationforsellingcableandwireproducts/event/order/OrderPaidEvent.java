package com.software.diploma.webapplicationforsellingcableandwireproducts.event.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class OrderPaidEvent extends ApplicationEvent {
    private Long userId;
    private List<CartProduct> cartProducts;

    public OrderPaidEvent(Object source, Long userId, List<CartProduct> cartProducts) {
        super(source);
        this.userId = userId;
        this.cartProducts = cartProducts;
    }
}
