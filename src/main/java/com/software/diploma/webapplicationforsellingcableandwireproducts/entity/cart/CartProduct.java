package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_product")
public class CartProduct extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    @ToString.Exclude
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @Column(nullable = false)
    private Integer totalProductAmount;

    @Column(nullable = false)
    private LocalDateTime addedAt;

    @PrePersist
    public void onCreate() {
        addedAt = LocalDateTime.now();
    }
}
