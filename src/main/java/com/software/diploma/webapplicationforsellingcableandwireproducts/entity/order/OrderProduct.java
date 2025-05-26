package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @Column(nullable = false)
    private Integer totalProductAmount;
}
