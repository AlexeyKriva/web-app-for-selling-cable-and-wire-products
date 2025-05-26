package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.Order;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.user.id = :orderId AND o.user.isDeleted = false")
    List<Order> findByProductIdAndProductNotDeleted(long orderId);
}
