package com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;

public interface CartService {
    Cart getByUserId(Long ownerId);
    Cart getById(Long Id);
    Cart save(Cart cart);
    Cart updateLastUpdatedAt(Long id);
}
