package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findAllByCartId(Long cartId, Pageable pageable);
//    @Modifying
//    @Transactional
//    @EntityGraph(attributePaths = {"cart", "user"})
//    @Query("DELETE FROM CartProduct cp WHERE cp.cart IN (SELECT c FROM Cart c WHERE c.user.id = :userId)")
    void deleteAllByCartId(Long cartId);
}
