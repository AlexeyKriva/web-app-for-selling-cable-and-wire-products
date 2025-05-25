package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_stats")
public class ProductStats extends BaseEntity {
    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int stockQuantity;

    @Column(nullable = false)
    private int soldCount;

    @Column(nullable = false)
    private int cartCount;

    @Column(nullable = false)
    private long viewCount;

    public ProductStats(Product product) {
        this.product = product;
    }
}
