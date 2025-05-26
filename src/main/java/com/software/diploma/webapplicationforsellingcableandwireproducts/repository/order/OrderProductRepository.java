package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
