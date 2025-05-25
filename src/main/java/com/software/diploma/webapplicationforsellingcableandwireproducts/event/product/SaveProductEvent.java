package com.software.diploma.webapplicationforsellingcableandwireproducts.event.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SaveProductEvent extends ApplicationEvent {
    private Product product;

    public SaveProductEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
