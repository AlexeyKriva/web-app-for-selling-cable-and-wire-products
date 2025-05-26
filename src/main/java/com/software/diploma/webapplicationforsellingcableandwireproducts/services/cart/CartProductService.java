package com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartTotalProductAmountDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartProductService {
    List<CartProduct> getAllByCartId(Long cartId, Pageable pageable);
    CartProduct save(CartProductSaveDto сartProductSaveDto);
    void deleteById(Long id);
    CartProduct updateTotalProductAmountById(Long id, CartTotalProductAmountDto cartTotalProductAmountDto);
    void deleteAllByCartId(Long cartId);
}
