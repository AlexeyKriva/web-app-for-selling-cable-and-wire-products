package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderUpdateStatusDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.Order;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = "application/json")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getAllByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Order> save(@Valid @RequestBody OrderSaveDto orderSaveDto) {
        return new ResponseEntity(service.save(orderSaveDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Order> updateStatusById(@PathVariable("id") long id,
                                                  @Valid @RequestBody OrderUpdateStatusDto orderUpdateStatusDto) {
        return ResponseEntity.ok(service.updateStatusById(id, orderUpdateStatusDto));
    }
}
