package com.software.diploma.webapplicationforsellingcableandwireproducts.services.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderProduct;

import java.util.List;

public interface OrderProductService {
    List<OrderProduct> getByOrderId(Long orderId);
}
