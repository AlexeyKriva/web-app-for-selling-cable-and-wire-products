package com.software.diploma.webapplicationforsellingcableandwireproducts.services.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderUpdateStatusDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllByUserId(Long userId);
    Order save(OrderSaveDto orderSaveDto);
    Order updateStatusById(Long id, OrderUpdateStatusDto orderUpdateStatusDto);
}
