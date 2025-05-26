package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartTotalProductAmountDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cart-products", produces = "application/json")
@RequiredArgsConstructor
public class CartProductController {
    private final CartProductService service;

    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartProduct>> getAllByCartId(@PathVariable("cartId") Long cartId,
                                                           Pageable pageable) {
        return ResponseEntity.ok(service.getAllByCartId(cartId, pageable));
    }

    @PostMapping
    public ResponseEntity<CartProduct> save(@Valid @RequestBody CartProductSaveDto cartProductSaveDto) {
        return new ResponseEntity<>(service.save(cartProductSaveDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CartProduct> updateTotalProductAmountById(
            @PathVariable("id") Long id,
            @Valid @RequestBody CartTotalProductAmountDto cartTotalProductAmountDto) {
        return ResponseEntity.ok(service.updateTotalProductAmountById(id, cartTotalProductAmountDto));
    }
}
