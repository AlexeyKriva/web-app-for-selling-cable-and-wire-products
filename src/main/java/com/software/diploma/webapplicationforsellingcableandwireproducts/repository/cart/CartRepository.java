package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @EntityGraph(attributePaths = {"user", "user.address", "cartProducts", "cartProducts.product"})
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.user.isDeleted = false")
    Optional<Cart> findByUserIdAndUserNotDeleted(Long userId);
}
