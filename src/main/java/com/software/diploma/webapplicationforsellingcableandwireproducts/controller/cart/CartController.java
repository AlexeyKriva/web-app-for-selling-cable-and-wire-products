package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/carts", produces = "application/json")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }
}
