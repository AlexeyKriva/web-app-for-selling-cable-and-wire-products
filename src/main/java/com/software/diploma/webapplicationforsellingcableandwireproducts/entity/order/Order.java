package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop_order")
public class Order extends BaseEntity {
    @OneToOne
    private User user;

    @Column(nullable = false)
    private BigDecimal totalSumInBelRub;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = true)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderProduct> orderProducts;

    @PrePersist
    public void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
