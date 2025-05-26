package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findAllByCartId(Long cartId, Pageable pageable);
}
