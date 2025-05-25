package com.software.diploma.webapplicationforsellingcableandwireproducts.event.product;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ProductViewEvent extends ApplicationEvent {
    private Long productId;

    public ProductViewEvent(Object source, Long productId) {
        super(source);
        this.productId = productId;
    }
}
